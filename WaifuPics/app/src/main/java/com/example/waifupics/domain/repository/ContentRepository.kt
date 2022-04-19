package com.example.waifupics.domain.repository

import com.example.waifupics.domain.entity.ContentEnt

interface ContentRepository {
    suspend fun getContent(): ContentEnt
}