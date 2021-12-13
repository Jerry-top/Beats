package com.dss.beats_music.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.dss.beats_music.network.bean.Song

class SongDiffCallback: DiffUtil.ItemCallback<Song>(){
    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem.equals(newItem)
    }
}