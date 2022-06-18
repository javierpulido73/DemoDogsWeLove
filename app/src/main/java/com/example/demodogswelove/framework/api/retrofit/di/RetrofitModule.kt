package com.example.demodogswelove.framework.api.retrofit.di

import com.example.demodogswelove.BuildConfig
import com.example.demodogswelove.R
import com.example.demodogswelove.framework.api.retrofit.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Javier Pulido on 17/junio/2022
 */
val retrofitModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), androidContext().getString(R.string.url_base)) }
    single { provideApiService(get()) }
}

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()


private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)