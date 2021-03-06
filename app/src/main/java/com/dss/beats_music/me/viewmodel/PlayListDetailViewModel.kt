package com.dss.beats_music.me.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dss.beats_music.cache.PlayListCache
import com.dss.beats_music.entity.PlayList
import com.dss.beats_music.network.OkCallback
import com.dss.beats_music.network.ServiceCreator
import com.dss.beats_music.network.SongService
import com.dss.beats_music.network.bean.PlayListDetail
import com.dss.beats_music.network.bean.PlayListDetailResult
import com.dss.beats_music.network.bean.Song
import com.dss.beats_music.network.bean.SongDetailResult
import com.dss.beats_music.util.UserBaseDataUtil
import java.lang.StringBuilder

class PlayListDetailViewModel(private val playListId:Long):ViewModel() {

    private val songService = ServiceCreator.create<SongService>()

    private val playListCache = PlayListCache()

    private val songIds = mutableListOf<Long>()

    /**
     * 歌单详情数据
     */
    val playListDetail = MutableLiveData<PlayListDetail>()

    /**
     * 歌曲数据
     */
    val songs = MutableLiveData<MutableList<Song>>()

    init {
        // 从缓存中获取数据
        playListCache.getPlayListCache(playListId){
            Log.e("tag","get cache id = ${playListId} ${it}")
            it?.let {
                playListDetail.value = it.playListDetail
                songs.value = it.songs
            }
        }
        // 网络请求获取数据
        requestData()
    }

    /**
     * 发送网络请求获取数据
     */
    fun requestData(){
        songService.getPlayListDetail(playListId,UserBaseDataUtil.getCookie())
                .enqueue(object :OkCallback<PlayListDetailResult>(){

                    override fun onSuccess(result: PlayListDetailResult) {
                        playListDetail.value = result.playlist
                        songIds.clear()
                        for(i in result.playlist.trackIds){
                            songIds.add(i.id)
                        }
                        songService.getSongDetail(getSongsIdString())
                                .enqueue(object :OkCallback<SongDetailResult>(){

                                    override fun onSuccess(result: SongDetailResult) {
                                        songs.value = result.songs
                                        // 缓存数据
                                        playListCache.cachePlayList(PlayList(playListDetail.value!!,result.songs))
                                    }
                                })
                    }
                })
    }

    /**
     * 拼接song id
     */
    private fun getSongsIdString():String{
        val result = StringBuilder()
        if(songIds.size == 0){
            return result.toString()
        }
        for(i in 0 until songIds.size-1){
            result.append("${songIds[i]},")
        }
        result.append(songIds[songIds.size-1])
        return result.toString()
    }

}