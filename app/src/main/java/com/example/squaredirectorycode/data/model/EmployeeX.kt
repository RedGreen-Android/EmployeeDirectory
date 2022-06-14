package com.example.squaredirectorycode.data.model

import com.google.gson.annotations.SerializedName

data class EmployeeX(
    val biography: String,
    @SerializedName("email_address")
    val email: String,
    val employee_type: String,
    @SerializedName("full_name")
    val name: String,
    val phone_number: String,
    val photo_url_large: String,
    @SerializedName("photo_url_small")
    val image: String,
    @SerializedName("team")
    val team: String,
    val uuid: String
)