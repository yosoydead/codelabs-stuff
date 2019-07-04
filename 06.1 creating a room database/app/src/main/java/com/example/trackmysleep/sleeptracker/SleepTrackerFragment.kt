package com.example.trackmysleep.sleeptracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.trackmysleep.R
import com.example.trackmysleep.databinding.FragmentSleepTrackerBinding

/*
* a fragment with a button to record start and end times for sleep, which are saved in a db
* cumulative data is displayed in a simple scrollable textView
* */
class SleepTrackerFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentSleepTrackerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sleep_tracker, container, false)

        return binding.root
    }
}