package com.example.waifupics.domain.repository

import com.example.waifupics.domain.entity.ContentEnt
import io.reactivex.rxjava3.core.Single

interface ContentRepository {
    fun getWaifu(): Single<ContentEnt>
    fun getHug(): Single<ContentEnt>
}