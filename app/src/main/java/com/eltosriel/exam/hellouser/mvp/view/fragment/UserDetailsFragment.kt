package com.eltosriel.exam.hellouser.mvp.view.fragment

import android.util.Log
import android.view.View
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.eltosriel.exam.hellouser.R
import com.eltosriel.exam.hellouser.base.BaseFragment
import com.eltosriel.exam.hellouser.databinding.FragmentUserDetailsBinding
import com.eltosriel.exam.hellouser.di.component.DaggerUserDetailsInjector
import com.eltosriel.exam.hellouser.di.component.UserDetailsInjector
import com.eltosriel.exam.hellouser.di.module.UtilityModule
import com.eltosriel.exam.hellouser.mvp.model.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_user_details.*
import javax.inject.Inject

class UserDetailsFragment: BaseFragment<FragmentUserDetailsBinding>() {

    @Inject
    lateinit var gson: Gson

    private lateinit var user: User
    private lateinit var mBinding: FragmentUserDetailsBinding
    private lateinit var mUserDetailsInjector: UserDetailsInjector

    override fun passDataBinding(binding: FragmentUserDetailsBinding) {
        val userString : String = arguments!!.getString("user")!!
        user = gson.fromJson(userString, User::class.java)
        Log.d("User details", user.firstName)

        mBinding = binding
    }

    override fun configureLayout(): Int = R.layout.fragment_user_details

    override fun applyDagger() {
        mUserDetailsInjector = DaggerUserDetailsInjector
            .builder()
            .utilityModule(UtilityModule())
            .build()

        mUserDetailsInjector.inject(this)
    }

    override fun configureUI(view: View) {
        super.configureUI(view)

        tvUsername.text = "${user.firstName} ${user.lastName}"
        tvEmail.text= user.emailAddress
        tvAddress.text = user.address
        tvDate.text = "${user.birthday} - ${user.age}"
        tvMobile.text = user.mobileNumber
        tvContactPerson.text = user.contact.name
        tvContactNumber.text = user.contact.contactNumber

        val colorGenerator = ColorGenerator.MATERIAL
        val colorCode = colorGenerator.randomColor
        val textDrawable = TextDrawable.builder().buildRound(user.firstName[0].toString(), colorCode)
        ivNameDrawable.setImageDrawable(textDrawable)
    }
}