package com.fernando.myprojects.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fernando.myprojects.R
import com.fernando.myprojects.adapter.MainAdapter
import com.fernando.myprojects.base.BaseFragment
import com.fernando.myprojects.databinding.FragmentMainBinding
import com.fernando.myprojects.helpers.CellClickListener
import com.fernando.myprojects.helpers.DataProject
import com.fernando.myprojects.helpers.MarginItemDecoration
import com.fernando.myprojects.model.ProjectModel
import javax.inject.Inject

class MainFragment @Inject constructor() : BaseFragment(), CellClickListener {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var adapter: MainAdapter

    // View initialization logic
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Binding
        binding = FragmentMainBinding.inflate(layoutInflater)

        return binding.root
    }

    // Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVariables()


    }

    // Initialize variables
    private fun initVariables() {

        // Init recycler
        adapter.setListener(this)
        adapter.setProjects(DataProject.projectList)
        binding.recyclerMain.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMain.addItemDecoration(MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.recycler)))
        binding.recyclerMain.adapter = adapter


    }

    override fun onCellClickListener(project: ProjectModel) {
//        val directions = RocketListFragmentDirections.navigateToRocketDetail(rocket)
//        findNavController().navigate(directions)
    }

}