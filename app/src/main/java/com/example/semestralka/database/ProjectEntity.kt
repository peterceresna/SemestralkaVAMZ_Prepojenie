package com.example.semestralka.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Projects")
data class ProjectEntity(
    @PrimaryKey(autoGenerate = false)
    var projectName: String,
    @ColumnInfo(name = "workedHours")
    var workedHours: Int,
    @ColumnInfo(name = "recommendedHours")
    var recommendedHours: Int
)
