package com.example.demodogswelove.framework.android.app

import android.app.Application
import com.example.demodogswelove.framework.api.retrofit.di.retrofitModule
import com.example.demodogswelove.framework.glide.glideModule
import com.example.demodogswelove.framework.koin.module.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/**
 * Created by Javier Pulido on 17/junio/2022
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(mainModule)
            modules(retrofitModule)
            modules(glideModule)
        }
    }
}