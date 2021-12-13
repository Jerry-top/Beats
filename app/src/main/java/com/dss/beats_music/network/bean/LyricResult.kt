package com.dss.beats_music.network.bean

data class LyricResult(
        var nolyric: Boolean = false,
        var lrc: Lrc
):Result()

data class Lrc(
        var lyric: String
)
