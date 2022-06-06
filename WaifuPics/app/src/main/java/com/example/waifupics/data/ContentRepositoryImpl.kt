package com.example.waifupics.data

import com.example.waifupics.data.api.Api
import com.example.waifupics.data.mapper.ContentMapper
import com.example.waifupics.domain.entity.ContentEnt
import com.example.waifupics.domain.repository.ContentRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val Api: Api,
    private val mapper: ContentMapper
) : ContentRepository {
    override fun getWaifu(): Single<ContentEnt> = Api.getWaifu().map {
        mapper.toContent(it)
    }

    override fun getHug(): Single<ContentEnt> = Api.getHugs().map {
        mapper.toContent(it)
    }
}