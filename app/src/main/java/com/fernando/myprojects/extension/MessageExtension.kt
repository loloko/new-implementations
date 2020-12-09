package com.fernando.myprojects.extension

import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.fernando.myprojects.R
import com.google.android.material.snackbar.Snackbar

fun View.snackBar(@StringRes stringRef: Int, isWarning: Boolean = false) {
    val snackBar = Snackbar.make(this, stringRef, Snackbar.LENGTH_LONG)

    if (isWarning)
        snackBar.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.app_red))
    else
        snackBar.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.app_blue))

    snackBar.show()
}


