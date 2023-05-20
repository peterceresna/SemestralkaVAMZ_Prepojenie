package com.example.semestralka.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ProjectEntity::class], version = 2, exportSchema = false)
abstract class ProjectDatabase : RoomDatabase() {
    abstract val projectDatabaseDao: ProjectDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: ProjectDatabase? = null

        fun getInstance(context: Context): ProjectDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                    ProjectDatabase::class.java, "Projects").fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance

            }
        }
    }
}
