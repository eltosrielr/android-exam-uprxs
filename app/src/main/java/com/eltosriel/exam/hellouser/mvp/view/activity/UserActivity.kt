package com.eltosriel.exam.hellouser.mvp.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.eltosriel.exam.hellouser.R
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(toolbar)
        setTitle(R.string.app_name_title)
    }
}
