package com.example.youtubeapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeapi.data.remote.model.Item
import com.example.youtubeapi.databinding.ItemPlaylistBinding

class PlaylistAdapter(
    val list: ArrayList<Item>,
    private val clickListener: (id: String, title: String) -> Unit):
    RecyclerView.Adapter<PlaylistAdapter.PlayListsViewHolder>() {

    inner class PlayListsViewHolder(val binding: ItemPlaylistBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Item) {
            binding.tvTitle.text = items.snippet.title
            binding.tvDesk.text = items.contentDetails.itemCount.toString() + " video series"
            binding.image.load(items.snippet.thumbnails.standard.url)
            itemView.setOnClickListener {
                clickListener(items.id, items.snippet.title)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
        return PlayListsViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}