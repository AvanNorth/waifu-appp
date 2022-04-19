package com.example.waifupics.data.mapper

import com.example.waifupics.data.model.Content
import com.example.waifupics.domain.entity.ContentEnt

class ContentMapper {
    fun toContent(content: Content): ContentEnt = ContentEnt(content.url)
}