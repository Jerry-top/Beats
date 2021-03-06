package com.dss.beats_music.me.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dss.beats_music.network.OkCallback
import com.dss.beats_music.network.SearchService
import com.dss.beats_music.network.ServiceCreator
import com.dss.beats_music.network.bean.DefaultSearchKeyResult
import com.dss.beats_music.network.bean.HotSearchListResult
import com.dss.beats_music.util.UserBaseDataUtil

class SearchViewModel:ViewModel() {

    private val searchService = ServiceCreator.create<SearchService>()

    /**
     * 默认搜索词
     */
    val defaultSearchKey = MutableLiveData<String>()

    /**
     * 搜索热词列表
     */
    val hotSearchList = MutableLiveData<MutableList<String>>()

    init {
        queryDefaultSearchKey()
        queryHotSearchList()
    }

    /**
     * 网络请求默认搜索词
     */
    fun queryDefaultSearchKey(){
        searchService.getDefaultSearchKey(UserBaseDataUtil.getCookie())
                .enqueue(object :OkCallback<DefaultSearchKeyResult>(){
                    override fun onSuccess(result: DefaultSearchKeyResult) {
                        defaultSearchKey.value = result.data.showKeyword
                    }
                })
    }

    /**
     * 网络请求搜索热词列表
     */
    fun queryHotSearchList(){
        searchService.getHotSearchList().enqueue(object :OkCallback<HotSearchListResult>(){
            override fun onSuccess(result: HotSearchListResult) {
                val hots = mutableListOf<String>()
                for(i in result.result.hots){
                    hots.add(i.searchName)
                }
                hotSearchList.value = hots
            }
        })
    }

}