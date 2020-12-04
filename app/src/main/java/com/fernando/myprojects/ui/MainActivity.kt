package com.fernando.myprojects.ui

import android.os.Bundle
import com.fernando.myprojects.R
import com.fernando.myprojects.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}