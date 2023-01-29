package com.example.mobileapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import com.example.mobileapp.ui.main.SectionsPagerAdapter
import com.example.mobileapp.dialogs.CreateTaskDialog
import com.example.mobileapp.dialogs.CreatTaskList
import com.example.mobileapp.dialogs.EditTaskList

//const val APP_PREFERENCES = "APP_PREFERENCES"

class MainActivity : AppCompatActivity() {

    //private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        val CreateTaskListBtn: ImageButton = findViewById(R.id.Button_create)
        val EditTaskListBtn: ImageButton = findViewById(R.id.Button_edit)
        val DelTaskListBtn: ImageButton = findViewById(R.id.Button_delete)

        fab.setOnClickListener {
            val myDialogFragment = CreateTaskDialog()
            myDialogFragment.show(supportFragmentManager, "Dialog_create_task")
        }

        CreateTaskListBtn.setOnClickListener {
            val myDialogFragment = CreatTaskList()
            myDialogFragment.show(supportFragmentManager, "Dialog_create_task_list")
        }

        EditTaskListBtn.setOnClickListener {
            val myDialogFragment = EditTaskList()
            myDialogFragment.show(supportFragmentManager, "Dialog_create_task_list")
        }

        DelTaskListBtn.setOnClickListener {
        }
    }


}