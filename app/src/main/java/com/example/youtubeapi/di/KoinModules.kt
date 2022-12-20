package com.example.youtubeapi.di

import com.example.youtubeapi.data.remote.networkModule

val koinModules = listOf(
    repoModules,
    viewModules,
    networkModule

)