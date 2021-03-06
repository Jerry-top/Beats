package com.dss.beats_music.video.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dss.beats_music.network.OkCallback
import com.dss.beats_music.network.ServiceCreator
import com.dss.beats_music.network.VideoService
import com.dss.beats_music.network.bean.RecommendVideoResult
import com.dss.beats_music.network.bean.VideoData
import com.dss.beats_music.util.UserBaseDataUtil

class VideoViewModel: ViewModel() {

    private val videoService = ServiceCreator.create<VideoService>()

    /**
     * 分页
     */
    private var offset = 0

    val recommendVideos = MutableLiveData<MutableList<VideoData>>()

    init {

        queryRecommendVideos(0)
    }

    /**
     * 请求推荐视频
     */
    private fun queryRecommendVideos(offset: Int){
        videoService.getRecommendVideo(offset,
                UserBaseDataUtil.getCookie(),
                System.currentTimeMillis())
                .enqueue(object :OkCallback<RecommendVideoResult>(){

                    override fun onSuccess(result: RecommendVideoResult) {
//                        Log.e("tag","success ${result.datas}")
                        var data = recommendVideos.value
                        if(data == null){
                            data = mutableListOf()
                        }
                        data.addAll(result.datas)
                        recommendVideos.value = data
                    }
                })
    }

    /**
     * 请求下一页数据
     */
    fun queryNextVideos(){
        offset++
        queryRecommendVideos(offset)
    }

    /**
     * 刷新数据
     */
    fun refreshVideos(){
        offset = 0
        if(recommendVideos.value != null){
            recommendVideos.value!!.clear()
        }
        queryRecommendVideos(offset)
    }

}