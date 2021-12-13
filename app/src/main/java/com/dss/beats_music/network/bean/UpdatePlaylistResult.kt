package com.dss.beats_music.network.bean

/**
 * 更新歌单的结果
 */
data class UpdatePlaylistResult(
        var status:Int,
        /**
         * 歌单id
         */
        var id:Long
)