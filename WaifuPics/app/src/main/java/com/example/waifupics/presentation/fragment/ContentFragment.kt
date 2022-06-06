package com.example.waifupics.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.waifupics.databinding.FragmentContentBinding
import com.example.waifupics.domain.entity.ContentEnt
import com.example.waifupics.presentation.presenter.content.ContentPresenter
import com.example.waifupics.presentation.presenter.content.ContentView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class ContentFragment : MvpAppCompatFragment(), ContentView {
    private lateinit var binding: FragmentContentBinding
    private lateinit var glide: RequestManager

    @Inject
    @InjectPresenter
    lateinit var presenter: ContentPresenter

    @ProvidePresenter
    fun providePresenter(): ContentPresenter = presenter

    override fun showError(throwable: Throwable) {
        Snackbar.make(
            binding.root,
            "Error. Check the Internet connection",
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        glide = Glide.with(this)

        binding.waifuBtn.setOnClickListener {
            presenter.onGetWaifuClick()
        }
        binding.hugBtn.setOnClickListener {
            presenter.onGetHugsClick()
        }
    }

    override fun showLoading() {
        with(binding) {
            content.isVisible = false
            progress.isVisible = true
        }
    }

    override fun hideLoading() {
        with(binding) {
            progress.isVisible = false
            content.isVisible = true
        }
    }

    override fun showContent(content: ContentEnt) {
        with(binding){
            glide.load(content.url).into(imageView)
        }
    }
}