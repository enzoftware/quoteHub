package com.enzoftware.projects.common

import android.app.AlertDialog
import android.content.Context
import com.enzoftware.projects.R

fun showGeneralError(context: Context) {

    AlertDialog.Builder(context)
        .setTitle(context.resources.getString(R.string.error_title))
        .setMessage(context.resources.getString(R.string.error_message))
        .setPositiveButton(context.resources.getString(R.string.accept_button_text))
        { dialog, _ -> dialog.dismiss() }
        .show()
}