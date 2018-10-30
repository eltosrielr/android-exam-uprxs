package com.eltosriel.exam.hellouser.di.component

import android.content.Context
import com.eltosriel.exam.hellouser.di.module.UserListContextModule
import com.eltosriel.exam.hellouser.di.module.UserListMvpModule
import com.eltosriel.exam.hellouser.di.module.UtilityModule
import com.eltosriel.exam.hellouser.di.qualifiers.FragmentContext
import com.eltosriel.exam.hellouser.di.scope.FragmentScope
import com.eltosriel.exam.hellouser.mvp.view.fragment.UserListFragment
import dagger.BindsInstance
import dagger.Component

@FragmentScope
@Component(modules = [UtilityModule::class, UserListMvpModule::class, UserListContextModule::class], dependencies = [AppInjector::class])
interface UserListInjector {

    @FragmentContext
    fun getContext(): Context

    fun inject(userListFragment: UserListFragment)
}