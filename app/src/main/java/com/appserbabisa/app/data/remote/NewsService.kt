package com.appserbabisa.app.data.remote

import com.appserbabisa.app.data.model.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET(value = "/")
    fun listNews() : Call<NewsList>

    @GET (value = "detail/")
    fun  detailNews(@Query(value = "url") url:String): Call<NewsList>

    @GET (value = "srch/")
    fun  sercNews(@Query(value = "q")query:String): Call<NewsList>


}