package com.fernando.myprojects.ui.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fernando.myprojects.base.BaseFragment
import com.fernando.myprojects.databinding.FragmentResetPasswordBinding
import javax.inject.Inject

class ResetPasswordFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentResetPasswordBinding

    // View initialization logic
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Binding
        binding = FragmentResetPasswordBinding.inflate(layoutInflater)

        return binding.root
    }

    // Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.imBackPress.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}