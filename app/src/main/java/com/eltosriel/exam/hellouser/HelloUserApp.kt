package com.eltosriel.exam.hellouser

import android.app.Application
import com.eltosriel.exam.hellouser.di.component.AppInjector
import com.eltosriel.exam.hellouser.di.component.DaggerAppInjector
import com.eltosriel.exam.hellouser.di.module.AppModule
import com.eltosriel.exam.hellouser.di.module.NetworkModule
import com.eltosriel.exam.hellouser.di.module.UtilityModule

class HelloUserApp : Application() {

    private lateinit var mAppInjector: AppInjector

    override fun onCreate() {
        super.onCreate()

        mAppInjector = DaggerAppInjector
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()

        mAppInjector.inject(this)
    }

    fun getComponentInjector(): AppInjector = mAppInjector
}