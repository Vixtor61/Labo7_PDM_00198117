package com.example.labo7_00198117.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labo7_00198117.database.daos.GithubRepoDAO
import com.example.labo7_00198117.database.entities.GithubRepo

@Database(
    entities = [GithubRepo::class],
    version = 1,
    exportSchema = false
)
public abstract class RoomDb: RoomDatabase(){
    abstract fun repoDAO():GithubRepoDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getInstance(
            context: Context
        ):RoomDb{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,RoomDb::class.java,"Repo_DB").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}