package com.eltosriel.exam.hellouser.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

abstract class BaseFragment<VDB : ViewDataBinding> : Fragment() {
    protected abstract fun passDataBinding(binding: VDB)
    protected abstract fun configureLayout(): Int
    protected abstract fun applyDagger()
    open fun configureUI(view: View) {}
    open fun configureBehavior() {}

    protected fun loadFragment(containerViewId: Int, fragment: Fragment) {
        fragmentManager!!.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
    }

//    protected fun loadFragmentWithAnimation(containerViewId: Int, fragment: Fragment) {
//        fragmentManager!!.beginTransaction()
//            .setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_top)
//            .replace(containerViewId, fragment)
//            .commit()
//    }

    protected fun navigate(resId: Int) {
        view?.let {
            Navigation.findNavController(it)
                .navigate(resId)
        }
    }

    protected fun navigate(resId: Int, bundle: Bundle) {
        view?.let {
            Navigation.findNavController(it)
                .navigate(resId, bundle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        applyDagger()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: VDB = DataBindingUtil.inflate(inflater, configureLayout(), container, false)
        passDataBinding(binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureUI(view)
        configureBehavior()
    }

    override fun getContext(): Context {
        return activity!!.applicationContext
    }
}