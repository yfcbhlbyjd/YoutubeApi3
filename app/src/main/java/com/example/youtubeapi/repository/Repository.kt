package com.example.youtubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi.BuildConfig.API_KEY
import com.example.youtubeapi.data.remote.ApiService
import com.example.youtubeapi.data.remote.model.Playlists
import kotlinx.coroutines.Dispatchers



class Repository(private val apiService: ApiService) {

    fun playlist(): LiveData<Playlists> {
        return liveData(Dispatchers.IO) {
            val response = apiService.getPlaylist(
                "snippet,contentDetails", "UCDF_NIAEkcAUvzxe1DUzaQA", API_KEY, 50
            )
            if (response.isSuccessful){
                response.body()?.let { emit(it) }
            }
        }
    }

}