package com.example.semestralka.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProjectDatabaseDao {

    @Insert
    suspend fun insert(project: ProjectEntity)

    @Update
    suspend fun update(project: ProjectEntity)

    @Query("SELECT * FROM Projects WHERE projectName = :key")
    suspend fun get(key: String): ProjectEntity?

    @Query("SELECT * FROM Projects")
    suspend fun getAllProjects(): List<ProjectEntity>?

    @Query("SELECT projectName FROM Projects")
    suspend fun getAllNames(): List<String>?

    @Query("DELETE FROM Projects")
    suspend fun clearDatabase()
}