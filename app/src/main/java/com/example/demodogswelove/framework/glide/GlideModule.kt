package com.example.demodogswelove.framework.glide

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.demodogswelove.R
import org.koin.android.ext.koin.androidApplication
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module

/**
 * Created by Javier Pulido on 17/junio/2022
 */
val glideModule = module {
    single { provideRequestOptions() }
    single { provideRequestManager(androidApplication(), get()) }
}

fun provideRequestManager(
    application: Application,
    requestOptions: RequestOptions
): RequestManager {
    return Glide.with(application)
        .setDefaultRequestOptions(requestOptions)
}

fun provideRequestOptions(): RequestOptions {
    return RequestOptions()
        .placeholder(R.drawable.ic_downloading)
        .error(R.drawable.ic_broken_image)
}

object GlideInstance : KoinComponent {
    val glide: RequestManager by inject()
}