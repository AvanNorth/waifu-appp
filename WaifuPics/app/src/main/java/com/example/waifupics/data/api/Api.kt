package com.example.waifupics.data.api

import com.example.waifupics.data.model.Content
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface Api {
 @GET("SFW/waifu")
 fun getWaifu(): Single<Content>
 @GET("SFW/hug)
 fun getHugs(): Single<Content>
}
