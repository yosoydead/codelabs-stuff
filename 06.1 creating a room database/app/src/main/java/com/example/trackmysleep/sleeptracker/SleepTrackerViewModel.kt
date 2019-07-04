package com.example.trackmysleep.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class SleepTrackerViewModel(val database: SleepDatabaseDao,
                            application: Application): AndroidViewModel(application) {
}