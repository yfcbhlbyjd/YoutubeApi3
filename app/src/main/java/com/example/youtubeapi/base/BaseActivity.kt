package com.example.youtubeapi.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.youtubeapi.base.BaseViewModel

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)
        checkInternet()
        setUI()
        setupLiveData()
        initClickListener()


    }

    open fun setupLiveData() {}

    open fun setUI() {}

    open fun initClickListener() {}

    open fun checkInternet() {}

}