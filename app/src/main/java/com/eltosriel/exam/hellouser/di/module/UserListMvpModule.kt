package com.eltosriel.exam.hellouser.di.module

import com.eltosriel.exam.hellouser.di.scope.FragmentScope
import com.eltosriel.exam.hellouser.mvp.view.UserListView
import dagger.Module
import dagger.Provides

@Module
class UserListMvpModule(val view: UserListView) {

    @Provides
    @FragmentScope
    fun provideView() = view
}