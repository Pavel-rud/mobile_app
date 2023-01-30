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
import android.util.Log
import com.example.mobileapp.database.DB
import com.example.mobileapp.util.Repository
import android.widget.ImageButton
import com.example.mobileapp.ui.main.SectionsPagerAdapter
import com.example.mobileapp.dialogs.CreateTaskDialog
import com.example.mobileapp.dialogs.CreatTaskList
import com.example.mobileapp.dialogs.EditTaskList
import com.example.mobileapp.dialogs.ErrorDeleteTaskList

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

        //val db = DB.getInstance(this@MainActivity)
        //val repository = Repository(db)

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            //override only methods you need, not all of them

            override fun onPageSelected(position: Int) {
                val ind = viewPager.currentItem
                Log.i(ind.toString(), ind.toString())
            }
        })

        fab.setOnClickListener {
            val ind = viewPager.currentItem
            Log.i(ind.toString(), ind.toString())
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
            if (viewPager.currentItem <= 1){
                val myDialogFragment = ErrorDeleteTaskList()
                myDialogFragment.show(supportFragmentManager, "Dialog_error_del_task_list")
            }
            else{
                // todo delete task list
            }

        }
    }


}