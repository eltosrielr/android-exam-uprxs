package com.eltosriel.exam.hellouser.remote.api

import com.eltosriel.exam.hellouser.mvp.model.Users
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {
    @GET("/b/5bd7de20716f9364f8cde4f6/1")
    fun getUsers(): Observable<Users>
}