package com.example.mobileapp.models

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val favorites: Boolean,
    val task_list_id: Int,
    val completed: Boolean = false
)