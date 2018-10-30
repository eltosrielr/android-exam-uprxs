package com.eltosriel.exam.hellouser.remote

import com.eltosriel.exam.hellouser.mvp.model.Users
import com.eltosriel.exam.hellouser.remote.api.UserApi
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(val api: UserApi){
    fun fetchAllUsers(): Observable<Users> = api.getUsers()
}