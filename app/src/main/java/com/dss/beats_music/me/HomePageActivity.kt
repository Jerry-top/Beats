package com.dss.beats_music.me

import android.os.Bundle
import com.dss.beats_music.BaseActivity
import com.dss.beats_music.databinding.ActivityHomePageBinding

class HomePageActivity : BaseActivity() {

    private lateinit var binding : ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}