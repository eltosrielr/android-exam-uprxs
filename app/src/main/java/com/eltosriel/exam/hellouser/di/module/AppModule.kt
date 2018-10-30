package com.eltosriel.exam.hellouser.di.module

import android.app.Application
import android.content.Context
import com.eltosriel.exam.hellouser.HelloUserApp
import com.eltosriel.exam.hellouser.di.qualifiers.ApplicationContext
import com.eltosriel.exam.hellouser.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(var context: Context) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext() = context

    @Provides
    @ApplicationScope
    fun provideApplication() : Application = context.applicationContext as HelloUserApp
}