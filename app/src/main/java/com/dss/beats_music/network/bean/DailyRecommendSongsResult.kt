package com.dss.beats_music.network.bean

data class DailyRecommendSongsResult(
        var data: Data
):Result()
{
    data class Data(
            var dailySongs: MutableList<Song>
    )
}