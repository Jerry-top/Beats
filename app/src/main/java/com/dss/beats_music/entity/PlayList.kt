package com.dss.beats_music.entity

import com.dss.beats_music.network.bean.PlayListDetail
import com.dss.beats_music.network.bean.Song

/**
 * 歌单 数据类
 */
data class PlayList(
        var playListDetail: PlayListDetail,
        var songs : MutableList<Song>
)
