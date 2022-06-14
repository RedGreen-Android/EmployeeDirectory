package com.example.squaredirectorycode.ui.utils

sealed class Status {
    object SUCCESS :Status()
    object ERROR :Status()
    object LOADING :Status()
}