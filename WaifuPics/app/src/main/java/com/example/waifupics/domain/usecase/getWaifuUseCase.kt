package com.example.waifupics.domain.usecase

import com.example.waifupics.domain.entity.ContentEnt
import com.example.waifupics.domain.repository.ContentRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class getWaifuUseCase @Inject constructor(
    private val rep: ContentRepository
) {
    operator fun invoke(): Single<ContentEnt> = rep.getWaifu().subscribeOn(Schedulers.io())
}