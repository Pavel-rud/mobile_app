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
import com.example.mobileapp.databinding.EditTaskListDialogBinding


class ErrorDeleteTaskList: AppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Can't delete this task list")
            .setMessage("You can't delete Favorites and My tasks")
            .setNegativeButton("Cancel") {dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.cancel()
            }
        val dialog = builder.create()
        return dialog
    }

    override fun onCancel(dialog: DialogInterface?) {
        super.onCancel(dialog)
    }
}