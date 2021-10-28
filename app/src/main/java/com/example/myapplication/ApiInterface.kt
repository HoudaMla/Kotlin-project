package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(value = "photos/?client_id=o-xiqdcqHW4T6R5Mh40viVaenYZ2xFw7tPJZB6mxUoI")
    fun getData(): Call<List<MyDataItem>>
}