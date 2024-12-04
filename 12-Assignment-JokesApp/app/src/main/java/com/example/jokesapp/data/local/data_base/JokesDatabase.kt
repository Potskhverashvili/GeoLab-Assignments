package com.example.jokesapp.data.local.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jokesapp.data.local.dao.JokeDao
import com.example.jokesapp.data.local.entity.JokeEntity

@Database(entities = [JokeEntity::class], version = 1)
abstract class JokesDatabase : RoomDatabase() {
    abstract val jokeDao: JokeDao

    companion object {
        fun create(context: Context): JokesDatabase {
            return Room.databaseBuilder(
                context,
                JokesDatabase::class.java,
                "JokesDatabase"
            ).build()
        }
    }
}