package com.example.waifupics.presentation.presenter.content

import com.example.waifupics.domain.entity.ContentEnt
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface ContentView: MvpView{
    @Skip
    fun showError(throwable: Throwable)

    fun showLoading()

    fun hideLoading()

    fun showContent(content: ContentEnt)
}