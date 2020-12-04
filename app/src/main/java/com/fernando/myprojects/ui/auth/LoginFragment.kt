package com.fernando.myprojects.ui.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fernando.myprojects.base.BaseFragment
import com.fernando.myprojects.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding

    // View initialization logic
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Binding
        binding = FragmentLoginBinding.inflate(layoutInflater)

        return binding.root
    }

    // Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.tvForgotPassword.setOnClickListener {
            navToResetPasswordScreen()
        }

        binding.tvSignUp.setOnClickListener {
            navToRegisterScreen()
        }

        binding.btSignInWithEmail.setOnClickListener {
            navToMainScreen()
        }

    }

    private fun navToMainScreen() {
        val directions = LoginFragmentDirections.actionLoginFragmentToMainFragment()
        findNavController().navigate(directions)
    }

    private fun navToResetPasswordScreen() {
        val directions = LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment()
        findNavController().navigate(directions)
    }

    private fun navToRegisterScreen() {
        val directions = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(directions)
    }


}