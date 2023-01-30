package com.example.mobileapp.database

import android.content.Context
//import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.mobileapp.database.TaskList.TaskList
import com.example.mobileapp.database.TaskList.TaskListDao
import com.example.mobileapp.database.Task.Task
import com.example.mobileapp.database.Task.TasksDao

@Database(
    entities = [Task::class, TaskList::class],
    exportSchema = true,
    version = 2
)
abstract class DB : RoomDatabase() {
    abstract fun getTasksDao(): TasksDao
    abstract fun getTaskListDao(): TaskListDao
    companion object {
        @Volatile
        private lateinit var instance: DB

        fun getInstance(context: Context): DB {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = createDatabase(context)
                }
                return instance
            }
        }
        private fun createDatabase(context: Context): DB {
            return Room.databaseBuilder(
                context,
                DB::class.java,
                "TasksDatabase"
            ).fallbackToDestructiveMigration().build()
        }
    }
}