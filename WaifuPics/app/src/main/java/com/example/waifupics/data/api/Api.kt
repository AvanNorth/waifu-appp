package com.example.waifupics.data.api

import com.example.waifupics.data.model.Content
import retrofit2.http.GET

interface Api {
 @GET("SFW/waifu")
 suspend fun getContent(): Content

}