package com.eltosriel.exam.hellouser.di.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.eltosriel.exam.hellouser.di.scope.ApplicationScope
import com.eltosriel.exam.hellouser.di.scope.FragmentScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module()
class UtilityModule {

    @Provides
    @FragmentScope
    fun provideSharedPreferences(application: Application) : SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @FragmentScope
    fun provideGson(): Gson =
        GsonBuilder().setLenient().create()
}