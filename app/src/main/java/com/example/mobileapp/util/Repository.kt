package com.example.mobileapp.util

import com.example.mobileapp.database.Task.Task
import com.example.mobileapp.database.DB
import com.example.mobileapp.database.TaskList.TaskList

class Repository(
    private val db: DB
) {
    suspend fun addTask(task: Task) = db.getTasksDao().insert(task)

    suspend fun deleteTask(task: Task) = db.getTasksDao().delete(task)

    suspend fun updateTask(task: Task) = db.getTasksDao().update(task)

    fun getAllTasks() = db.getTasksDao().getAll()

    fun getTaskById(id: Int) = db.getTasksDao().get(id)

    suspend fun addSubtask(tasklist: TaskList) = db.getTaskListDao().insert(tasklist)

    suspend fun deleteSubtask(tasklist: TaskList) = db.getTaskListDao().delete(tasklist)

    suspend fun updateSubtask(tasklist: TaskList) = db.getTaskListDao().update(tasklist)

    //fun getAllSubtasks(TaskID: Int) = db.getSubtasksDao().getAll(TaskID)

    //fun getAllCompletedSubtasks(TaskID: Int) = db.getSubtasksDao().getAllCompleted(TaskID)

    fun getSubtaskById(id: Int) = db.getTaskListDao().get(id)

}