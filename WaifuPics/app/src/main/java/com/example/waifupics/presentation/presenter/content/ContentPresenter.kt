package com.example.waifupics.presentation.presenter.content

import com.example.waifupics.domain.usecase.getHugsUseCase
import com.example.waifupics.domain.usecase.getWaifuUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class ContentPresenter @Inject constructor(
    private val getWaifuUseCase: getWaifuUseCase,
    private val getHugsUseCase: getHugsUseCase
) : MvpPresenter<ContentView>() {
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun attachView(view: ContentView?) {
        super.attachView(view)
    }

    override fun detachView(view: ContentView?) {
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun onGetWaifuClick() {
        disposables += getWaifuUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = {
                viewState.showContent(it)
            }, onError = {
                viewState.showError(it)
            })
    }
    fun onGetHugsClick() {
        disposables += getHugsUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = {
                viewState.showContent(it)
            }, onError = {
                viewState.showError(it)
            })
    }
}