package com.example.youtubeapi.core.ui.playlist


import androidx.lifecycle.LiveData
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.data.remote.model.Playlists
import com.example.youtubeapi.repository.Repository


class PlaylistViewModel(private val repository: Repository): BaseViewModel() {

    fun playlist(): LiveData<Playlists> {
        return repository.playlist()
    }
}