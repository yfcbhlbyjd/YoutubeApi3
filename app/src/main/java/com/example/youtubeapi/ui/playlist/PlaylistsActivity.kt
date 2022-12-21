package com.example.youtubeapi.ui.playlist

import android.content.Intent
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.data.remote.models.Item
import com.example.youtubeapi.databinding.ActivityPlaylistBinding
import com.example.youtubeapi.ui.playlist_detail.SecondActivity
import com.example.youtubeapi.utils.CheckConnectNetwork
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistsActivity : BaseActivity<PlaylistsViewModel, ActivityPlaylistBinding>() {
    override val viewModel: PlaylistsViewModel by viewModel()
    lateinit var adapter: PlaylistsAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }


    private fun onItemClick(channelId: String, playlistTitle: String, playlistDescription: String) {
        Intent(this, SecondActivity::class.java).apply {
            putExtra(FIRST_KEY, channelId)
            putExtra(SECOND_KEY, playlistTitle)
            putExtra(THIRD_KEY, playlistDescription)

            startActivity(this)
        }
    }


    override fun initViewModel() {
        viewModel.getPlaylists().observe(this) {
        if (it != null) {
            adapter = PlaylistsAdapter(it.items as ArrayList<Item>, this::onItemClick)
        }
        binding.recyclerView.adapter = adapter
    }
    }

    override fun initView() {

    }


    override fun checkInternet() {
        super.checkInternet()
        CheckConnectNetwork(this).observe(this) {
            binding.includeNoInet.rlParent.isVisible = !it
            binding.recyclerView.isVisible = it

            if (it == true) {
                initViewModel()
            }
        }
    }
    companion object {
        const val FIRST_KEY = "one_key"
        const val SECOND_KEY = "two_key"
        const val THIRD_KEY = "third_key"
    }
}