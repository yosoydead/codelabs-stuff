package com.example.trackmysleep.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//the database annotation needs 3 parameters: list of entity/entities, ersion number, bool to export schema
@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase: RoomDatabase(){
    abstract val sleepDatabaseDao: SleepDatabaseDao

    /*
    * this object allows clients to access methods for creating or getting the database
    * without instantiating the class
    * */
    companion object {

        /*
        * volatile means the variable will never be cached and all writes and reads will be done
        *   to and from the main memory
        *  this helps make sure the value of INSTANCE is always up-to-date and the same to all
        *   execution threads. changes made by one thread to INSTANCE are visible to all other threads
        *   immediately and you dont get a situation where two threads each update the same entity in a cache
        * */
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        //return the instance for the database
        fun getInstance(context: Context): SleepDatabase{
            /*
            * by wrapping the code in this block means that only one thread of execution at a time
            *   can enter this block of code, which makes sure the database only gets initialized once
            *
            * multiple threads can ask for a database instance at the same time. this eliminates the problem
            * */
            synchronized(this){
                var instance = INSTANCE

                //if the databse instance is null(doesnt exist) use the databaseBuilder to make one
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_history_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}