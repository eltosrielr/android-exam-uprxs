package com.eltosriel.exam.hellouser.mvp.view

import com.eltosriel.exam.hellouser.mvp.model.User

interface UserDetailsView {
    fun showDetails(user: User)
    fun showLoading()
    fun hideLoading()
}