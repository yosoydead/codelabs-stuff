package com.example.trackmysleep.sleepquality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.trackmysleep.R
import com.example.trackmysleep.databinding.FragmentSleepQualityBinding

/*
* fragment that displays a list of clickable icons, each representing the sleep quality rating
* */
class SleepQualityFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentSleepQualityBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_sleep_quality, container, false)

        val application = requireNotNull(this.activity).application

        return binding.root
    }
}