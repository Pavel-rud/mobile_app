package com.example.mobileapp.database.Task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tasks")
class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "Title")
    val title: String,
    @ColumnInfo(name = "Description", defaultValue = "")
    val description: String,
    @ColumnInfo(name = "Date", defaultValue = "")
    val date: String,
    @ColumnInfo(name = "isCompleted", defaultValue = false.toString())
    val isCompleted: Boolean = false,
    @ColumnInfo(name = "isFavorite", defaultValue = false.toString())
    var isFavorite: Boolean = false,
    @ColumnInfo(name = "idList", defaultValue = 0.toString())
    var idList: Int = 0
)