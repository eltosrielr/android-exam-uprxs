package com.eltosriel.exam.hellouser.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import com.eltosriel.exam.hellouser.di.qualifiers.FragmentContext
import com.eltosriel.exam.hellouser.di.scope.FragmentScope
import com.eltosriel.exam.hellouser.mvp.view.fragment.UserListFragment
import dagger.Module
import dagger.Provides

@Module
class UserListContextModule(var fragment: UserListFragment) {
    lateinit var context: Context

    @Provides
    @FragmentScope
    fun provideFragment() = fragment

    @Provides
    @FragmentScope
    @FragmentContext
    fun provideContext() : Context {
        context = fragment.context
        return context
    }
}