package com.example.youtubeapi.di

import com.example.youtubeapi.core.ui.playlist.PlaylistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val viewModules: Module = module {
    viewModel { PlaylistViewModel(get()) }

}