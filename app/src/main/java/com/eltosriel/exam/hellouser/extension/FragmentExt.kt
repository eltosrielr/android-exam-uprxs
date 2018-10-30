package com.eltosriel.exam.hellouser.extension

import androidx.fragment.app.Fragment
import com.eltosriel.exam.hellouser.HelloUserApp
import com.eltosriel.exam.hellouser.di.component.AppInjector

val Fragment.app: HelloUserApp get() = activity!!.application as HelloUserApp

fun Fragment.getAppInjector(): AppInjector = (app).getComponentInjector()