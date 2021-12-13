package com.dss.beats_music.network.bean

data class SearchSongResult(
        var result: Result


) : Result() {
    data class Result(
            var songs: MutableList<SearchSong>,
            var hasMore: Boolean
    )
}

data class SearchSong(
        var id: Long,
        var name: String,
        var duration: Int,
        var artists: MutableList<Ar>,
        var album: Al

)
