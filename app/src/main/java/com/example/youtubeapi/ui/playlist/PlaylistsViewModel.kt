package com.example.youtubeapi.ui.playlist

import androidx.lifecycle.LiveData
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.remote.models.Playlists
import com.example.youtubeapi.repository.Repository

class PlaylistsViewModel(private val repository: Repository): BaseViewModel() {

    fun getPlaylists(): LiveData<Playlists?> {
        return repository.getPlaylists()
    }
}