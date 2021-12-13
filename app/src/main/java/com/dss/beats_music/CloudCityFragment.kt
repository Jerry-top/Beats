package com.dss.beats_music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dss.beats_music.databinding.FragmentCloudCityBinding

class CloudCityFragment : Fragment() {

    private val TAG = "CloudCityFragment"

    private var _binding: FragmentCloudCityBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?
                              , savedInstanceState: Bundle?): View? {
        _binding = FragmentCloudCityBinding.inflate(inflater, container, false)

        return binding.root
    }
}