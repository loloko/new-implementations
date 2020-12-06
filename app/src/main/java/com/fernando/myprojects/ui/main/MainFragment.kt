package com.fernando.myprojects.ui.main


import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
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

        setHasOptionsMenu(true)

//        findNavController().popBackStack()

        return binding.root
    }

    // Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVariables()

    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)

        val searchItem: MenuItem? = menu.findItem(R.id.action_search)
        val searchView: SearchView = searchItem?.actionView as SearchView

        // Listener for searching rocket by name (Searching View)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
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