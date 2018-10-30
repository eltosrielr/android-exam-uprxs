package com.eltosriel.exam.hellouser.util

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["setError", "start"], requireAll = false)
fun setError(editText: EditText, errorValue: String, isStarted: Boolean) {
    if (!isStarted)
        if (editText.text.toString().isEmpty())
            editText.error = "Please enter your ${errorValue.decapitalize()}"
        else editText.error = ""
    else editText.error = ""
}

@BindingAdapter("isVisibleWhen")
fun isGoneWhen(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}