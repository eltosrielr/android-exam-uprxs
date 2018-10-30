package com.eltosriel.exam.hellouser.mvp.presenter.interactor

import android.annotation.SuppressLint
import android.util.Log
import com.eltosriel.exam.hellouser.mvp.presenter.UserListPresenter
import com.eltosriel.exam.hellouser.mvp.view.UserListView
import com.eltosriel.exam.hellouser.remote.api.UserApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserListInteractor @Inject constructor(private var api: UserApi, private var view: UserListView) :
    UserListPresenter {

    @SuppressLint("CheckResult")
    override fun fetchAllUsers() {
        view.showLoading()

        api.getUsers().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showUsers(it)
            }, {
                view.hideLoading()
                Log.d("Error", it.message)
            }, {
                view.hideLoading()
            })
    }
}