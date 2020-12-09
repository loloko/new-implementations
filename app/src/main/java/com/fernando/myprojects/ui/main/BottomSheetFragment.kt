package com.fernando.myprojects.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fernando.myprojects.base.BaseFragment
import com.fernando.myprojects.databinding.BottomsheetContentBinding
import com.fernando.myprojects.databinding.FragmentBottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import javax.inject.Inject


class BottomSheetFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentBottomsheetBinding

    //    private lateinit var  windowPreferencesManager: WindowPreferencesManager
    private lateinit var bottomSheetDialog: BottomSheetDialog

    private lateinit var bindingDialog: BottomsheetContentBinding

    // View initialization logic
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Binding
        binding = FragmentBottomsheetBinding.inflate(layoutInflater)


        return binding.root
    }

    // Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createBottomSheetDialog()

        binding.bottomsheetButton.setOnClickListener { v ->

            bottomSheetDialog.show()
            bottomSheetDialog.setTitle("Some random Title")
        }

    }

    private fun createBottomSheetDialog() {
        // Set up BottomSheetDialog

        bindingDialog = BottomsheetContentBinding.inflate(layoutInflater)

        bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bindingDialog.root)
        bottomSheetDialog.dismissWithAnimation = true


        bindingDialog.btBottomsheetContent.text = "Olaaaaaaaa bebe"

    }


}