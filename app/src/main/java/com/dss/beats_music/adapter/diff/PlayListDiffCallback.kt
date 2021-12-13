package com.dss.beats_music.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.dss.beats_music.network.bean.PlayList

class PlayListDiffCallback:DiffUtil.ItemCallback<PlayList>() {

    override fun areItemsTheSame(oldItem: PlayList, newItem: PlayList): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: PlayList, newItem: PlayList): Boolean {
        return oldItem.equals(newItem)
    }
}