package com.example.waifupics.data

import com.example.waifupics.data.api.Api
import com.example.waifupics.data.mapper.ContentMapper
import com.example.waifupics.domain.entity.ContentEnt
import com.example.waifupics.domain.repository.ContentRepository

class ContentRepositoryImpl(
    private val Api: Api,
    private val mapper: ContentMapper
): ContentRepository {
    override suspend fun getContent(): ContentEnt = mapper.toContent(Api.getContent())
}