package com.example.youtubeapi.core.ui.playlist

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi.base.BaseActivity
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.youtubeapi.core.ui.playlist_detail.PlaylistDetailActivity
import com.example.youtubeapi.core.network.CheckConnect
import com.example.youtubeapi.data.remote.model.Item
import com.example.youtubeapi.databinding.ActivityPlaylistBinding
import com.example.youtubeapi.ui.PlaylistAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>() {

    private lateinit var adapter: PlaylistAdapter
    private lateinit var check:  CheckConnect

    override val viewModel: PlaylistViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun setUI() {
        binding.recyclerPlaylist.adapter = adapter
        binding.recyclerPlaylist.layoutManager = LinearLayoutManager(this)

    }



    override fun checkInternet() {
        CheckConnect((getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this) {
                binding.checkInet.constInternet.isVisible = !it
                binding.recyclerPlaylist.isVisible = it

                if (it == true) {
                    setupLiveData()
                }
            }
    }

    override fun setupLiveData() {
        viewModel.playlist().observe(this){
            if (it != null) {
                adapter = PlaylistAdapter(it.items as ArrayList<Item>, this::initClickListener)
            }
            binding.recyclerPlaylist.adapter = adapter
        }

    }


    private fun initClickListener(id:String, title: String) {
        val intent = Intent(this, PlaylistDetailActivity::class.java)
        intent.putExtra("keyId", id)
        intent.putExtra("keyTitle", title)
        startActivity(intent)
            Toast.makeText(this@PlaylistActivity, "open text screen", Toast.LENGTH_LONG).show()
        }

}






