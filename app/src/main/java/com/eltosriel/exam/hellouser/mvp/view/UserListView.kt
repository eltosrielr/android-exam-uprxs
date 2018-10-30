package com.eltosriel.exam.hellouser.mvp.view

import com.eltosriel.exam.hellouser.mvp.model.Users

interface UserListView{
    fun showUsers(users: Users)
    fun showLoading()
    fun hideLoading()
}