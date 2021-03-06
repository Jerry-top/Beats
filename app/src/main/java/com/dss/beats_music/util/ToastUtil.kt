package com.dss.beats_music.util

import android.os.Looper
import android.widget.Toast
import com.dss.beats_music.MyApplication


private var toast: Toast? = null

/**
 * 显示Toast
 * 如果不在主线程会切换到主线程
 */
@JvmOverloads
fun showToast(content: String,duration: Int = Toast.LENGTH_SHORT){
    if(Looper.myLooper() == Looper.getMainLooper()){
        if(toast == null){
            toast = Toast.makeText(MyApplication.getContext(),content,duration)
        }else{
            toast?.setText(content)
        }
        toast?.show()
    }else{
        MyApplication.post{
            showToast(content,duration)
        }
    }
}