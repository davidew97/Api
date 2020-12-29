package com.appserbabisa.app.data.model

data class NewsList (
    val data : List<News> = arrayListOf(),
    val length : Int=0,
    val Status : Int=0
)