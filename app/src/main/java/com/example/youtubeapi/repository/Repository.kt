package com.example.youtubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.data.remote.models.Playlists
import com.example.youtubeapi.data.remote.ApiService
import com.example.youtubeapi.utils.Constant
import kotlinx.coroutines.Dispatchers


class Repository(private val apiService: ApiService) {

    fun getPlaylists(): LiveData<Playlists?> {
        return liveData(Dispatchers.IO) {
            val response = apiService.getPlaylists(
                Constant.channelId, Constant.part, BuildConfig.API_KEY, Constant.maxResult
            )
            if (response.isSuccessful) {
                emit(response.body())
            }
        }
    }
}