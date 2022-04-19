package com.example.waifupics.di

import com.example.waifupics.data.ContentRepositoryImpl
import com.example.waifupics.data.api.Api
import com.example.waifupics.data.mapper.ContentMapper
import com.example.waifupics.domain.repository.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMapper(): ContentMapper = ContentMapper()

    @Provides
    @Singleton
    fun provideContentRep(mapper: ContentMapper, api: Api): ContentRepository = ContentRepositoryImpl(api,mapper)
}