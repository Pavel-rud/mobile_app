package com.example.mobileapp.database.TaskList

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskListDao {
    @Query("SELECT * FROM Tasks")
    fun getAll(): LiveData<List<TaskList>>

    @Query("SELECT * FROM Tasks WHERE id = :id")
    fun get(id: Int): LiveData<TaskList>

    @Delete
    suspend fun delete(tasklist: TaskList)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tasklist: TaskList)

    @Update
    suspend fun update(tasklist: TaskList)
}