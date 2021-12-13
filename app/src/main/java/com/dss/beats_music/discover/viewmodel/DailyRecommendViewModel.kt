package com.dss.beats_music.discover.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dss.beats_music.network.DiscoverService
import com.dss.beats_music.network.OkCallback
import com.dss.beats_music.network.ServiceCreator
import com.dss.beats_music.network.bean.DailyRecommendSongsResult
import com.dss.beats_music.network.bean.Song
import com.dss.beats_music.util.UserBaseDataUtil

class DailyRecommendViewModel :ViewModel(){

    private val discoverService = ServiceCreator.create<DiscoverService>()

    val songList = MutableLiveData<MutableList<Song>>()

    init {
        requestData()
    }

    fun requestData(){
        discoverService.getDailyRecommendSongs(UserBaseDataUtil.getCookie())
                .enqueue(object :OkCallback<DailyRecommendSongsResult>(){


                    override fun onSuccess(result: DailyRecommendSongsResult) {
                        songList.value = result.data.dailySongs
                    }

                })
    }

}