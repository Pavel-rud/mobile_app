package com.example.mobileapp.dialogs

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.mobileapp.databinding.CreateTaskListDialogBinding


class CreatTaskList: AppCompatDialogFragment() {
    private var _binding: CreateTaskListDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = CreateTaskListDialogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Add a new task")
            .setView(binding.root)
            .setNegativeButton("Cancel") {dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, _ ->
                val title = binding.taskListName.text.toString()
                dialog.cancel()
            }
        val dialog = builder.create()


        binding.taskListName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = !binding.taskListName.text.isNullOrEmpty()
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