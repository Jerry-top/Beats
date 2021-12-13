package com.dss.beats_music.cache

import com.dss.beats_music.entity.PlayerSong
import com.dss.beats_music.util.DiskCacheUtil

/**
 * 缓存最后一次播放的歌曲和列表
 */
class RecentPlayCache {

    private val dirName = "/RecentPlayCache"

    fun cachePlayList(playList:List<PlayerSong>){
        DiskCacheUtil.set("$dirName/playlist",playList)
    }

    fun getPlayListCache(callback:(List<PlayerSong>?)->Unit){
        DiskCacheUtil.get<List<PlayerSong>>("$dirName/playlist"){
            callback(it)
        }
    }

    fun cacheLastSongIndex(index:Int){
        DiskCacheUtil.set("$dirName/index",index)
    }

    fun getIndexCache(callback:(Int?)->Unit){
        DiskCacheUtil.get<Int>("$dirName/index"){
            callback(it)
        }
    }

}