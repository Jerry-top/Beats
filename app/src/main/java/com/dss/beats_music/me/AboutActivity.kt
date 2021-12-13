package com.dss.beats_music.me

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dss.beats_music.R
import com.dss.beats_music.databinding.ActivityAboutBinding
import com.zhouwei.blurlibrary.EasyBlur
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 设置背景图
        setBackgroundImg()

    }

    private fun setBackgroundImg() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sssss)
        val blurBitmap = EasyBlur.with(this)
                .bitmap(bitmap)
                .radius(25)
                .scale(6)
                .blur()
        Glide.with(this)
                .load(blurBitmap)
                .into(backgroundImg)
    }
}