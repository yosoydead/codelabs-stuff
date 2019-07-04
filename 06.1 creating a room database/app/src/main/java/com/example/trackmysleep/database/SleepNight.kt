package com.example.trackmysleep.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//this class will be the model of each entry in the database of a sleep night
//an id must be used to uniquely identify the night
//sleepQuality is = -1 initially because no quality data has been collected
//endTime is = startTime at first because no end time has been recorded yet

@Entity(tableName = "daily_sleep_quality_table")
data class SleepNight(
    @PrimaryKey(autoGenerate = true)
    var nightId: Long = 0L, //this is the id of each sleep so it must be a primary key. it is also
    //auto incremented

    @ColumnInfo(name="start_time_milli") //ColumnInfo specifies what will be the name of the column
    //in the database when it will be created
    val startTimeMilli: Long = System.currentTimeMillis(),

    @ColumnInfo(name="end_time_milli")
    var endTimeMilli: Long = startTimeMilli,

    @ColumnInfo(name="quality_rating")
    var sleepQuality: Int = -1
)