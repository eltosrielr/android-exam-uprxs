package com.eltosriel.exam.hellouser.di.component

import com.eltosriel.exam.hellouser.di.module.UtilityModule
import com.eltosriel.exam.hellouser.di.scope.FragmentScope
import com.eltosriel.exam.hellouser.mvp.view.fragment.UserDetailsFragment
import dagger.Component

@FragmentScope
@Component(modules = [UtilityModule::class])
interface UserDetailsInjector {

    fun inject(userDetailsFragment: UserDetailsFragment)
}