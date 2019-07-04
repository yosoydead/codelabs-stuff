package com.example.trackmysleep.sleeptracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

//code for viewmodel factory
//creates a viewmodel which has some parameters attached to it
class SleepTrackerViewModelFactory(private val dataSource: SleepDatabaseDao,
                                   private val application: Application): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SleepTrackerViewModel::class.java)){
            return SleepTrackerViewModel(dataSource, application) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}