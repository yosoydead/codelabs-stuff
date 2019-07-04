package com.example.trackmysleep.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/*
* For this database, i should be able to:
*   - insert a new night
*   - update an existing night (to provide an end time and a quality rating)
*   - get a specific night based on its key
*   - get all nights so i can display them all
*   - get the most recent night
*   - delete all entries in the database
* */
@Dao
interface  SleepDatabaseDao{

    @Insert //this will generate the needed code for me to add a new entry in the database
    fun insert(night: SleepNight)

    @Update //update a certain entry from the db
    fun update(night: SleepNight)

    @Query("SELECT * FROM daily_sleep_quality_table WHERE nightId = :key")
    fun get(key: Long): SleepNight?

    //delete everything from the db
    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()

    //get the last night recorded
    //to do this, just sort all records and return the one with the biggest id
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    fun getTonight(): SleepNight?

    //get a list of all nights recorded
    //have it be LiveData so a ViewModel can use it
    @Query("SELECT * FROM  daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>
}