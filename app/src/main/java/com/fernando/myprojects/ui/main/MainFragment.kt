package com.fernando.myprojects.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fernando.myprojects.base.BaseFragment
import com.fernando.myprojects.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    // View initialization logic
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Binding
        binding = FragmentMainBinding.inflate(layoutInflater)

        return binding.root
    }

    // Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

}