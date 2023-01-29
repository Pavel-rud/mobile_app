package com.example.mobileapp.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mobileapp.R
import androidx.databinding.DataBindingUtil
import android.app.DatePickerDialog
import android.text.TextWatcher
import android.text.Editable
import com.example.mobileapp.masks.DateInputMask

import com.example.mobileapp.databinding.EditTaskDialogBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*



class EditTaskDialog : AppCompatDialogFragment() {
    private var _binding: EditTaskDialogBinding? = null
    private val binding get() = _binding!!
    //private lateinit var binding: CreateTaskDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //binding = DataBindingUtil.setContentView(this@CreateTaskDialog, R.layout.create_task_dialog)

        _binding = EditTaskDialogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(requireActivity())
        //builder.setView(R.layout.create_task_dialog)
        //binding.name = "hi"
        //val nameinput: EditText = findViewById(R.id.task_name)
        builder.setTitle("Add a new task")
            .setView(binding.root)
            .setNegativeButton("Cancel") {dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, _ ->
                val title = binding.taskName.text.toString()
                val description = binding.taskDescription.text.toString()
                val date = binding.taskDate.text.toString()
                val favorite: Boolean = binding.taskFavorite.isChecked()

                dialog.cancel()
            }
        DateInputMask(binding.taskDate){
        }

        val dialog = builder.create()

        binding.btnSetDate.setOnClickListener {
            Log.i("lol", "lol")
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, yearPicked, monthPicked, dayPicked ->
                    calendar.set(Calendar.YEAR, yearPicked)
                    calendar.set(Calendar.MONTH, monthPicked)
                    calendar.set(Calendar.DAY_OF_MONTH, dayPicked)
                    val formatted = SimpleDateFormat("dd.mm.yyyy", Locale.US).format(calendar.time)
                    binding.date = formatted.toString()
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        binding.taskName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = !binding.taskName.text.isNullOrEmpty()
            }
        })
        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = false
        }
        return dialog
    }

    override fun onCancel(dialog: DialogInterface?) {
        super.onCancel(dialog)
    }

}