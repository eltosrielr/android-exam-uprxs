package com.eltosriel.exam.hellouser.mvp.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("contact")
    var contact: ContactPerson,
    @SerializedName("address")
    var address: String,
    @SerializedName("mobile_number")
    var mobileNumber: String,
    @SerializedName("email_address")
    var emailAddress: String,
    @SerializedName("age")
    var age: Int,
    @SerializedName("birthday")
    var birthday: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("last_name")
    var lastName: String,
    @SerializedName("id")
    var id: Int
)

data class ContactPerson(
    @SerializedName("name")
    var name: String,
    @SerializedName("mobile_number")
    var contactNumber: String
)

data class Users(
    @SerializedName("users")
    var users: List<User>
)