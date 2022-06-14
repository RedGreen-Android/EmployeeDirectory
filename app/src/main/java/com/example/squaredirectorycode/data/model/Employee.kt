package com.example.squaredirectorycode.data.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("full_name")
    val name: String,
    @SerializedName("email_address")
    val email: String,
    @SerializedName("team")
    val team: String,
    @SerializedName("photo_url_small")
    val image: String
)
