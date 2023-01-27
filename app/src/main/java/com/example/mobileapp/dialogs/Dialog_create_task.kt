package com.example.mobileapp.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialogFragment
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mobileapp.R


class DialogCreateTask : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(R.layout.create_task_dialog);
        builder.setTitle("Add a new task")
            .setNegativeButton("Cancel") {dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") {
                    dialog, id ->  dialog.cancel()
            }

        return builder.create()
    }

}