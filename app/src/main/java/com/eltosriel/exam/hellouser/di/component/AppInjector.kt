package com.eltosriel.exam.hellouser.di.component

import android.content.Context
import com.eltosriel.exam.hellouser.HelloUserApp
import com.eltosriel.exam.hellouser.di.module.AppModule
import com.eltosriel.exam.hellouser.di.module.NetworkModule
import com.eltosriel.exam.hellouser.di.module.UtilityModule
import com.eltosriel.exam.hellouser.di.qualifiers.ApplicationContext
import com.eltosriel.exam.hellouser.di.scope.ApplicationScope
import com.eltosriel.exam.hellouser.remote.api.UserApi
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppInjector {

    fun userApi(): UserApi

    @ApplicationContext
    fun getContext(): Context

    fun inject(helloUserApp: HelloUserApp)
}