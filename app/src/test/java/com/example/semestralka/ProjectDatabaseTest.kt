package com.example.semestralka

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.semestralka.database.ProjectDatabase
import com.example.semestralka.database.ProjectDatabaseDao
import com.example.semestralka.database.ProjectEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ProjectDatabaseTest {
    private lateinit var projectDao: ProjectDatabaseDao
    private lateinit var db: ProjectDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, ProjectDatabase::class.java).allowMainThreadQueries()
            .build()
        projectDao = db.projectDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    suspend fun insertandGetProject() {
        val project = ProjectEntity("ORW", 10, 20)
        projectDao.insert(project)
        val projectGet = projectDao.get("ORW")
        assertEquals(projectGet?.projectName, "ORW")

    }
}