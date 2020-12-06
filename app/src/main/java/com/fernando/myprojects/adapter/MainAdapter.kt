package com.fernando.myprojects.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.fernando.myprojects.R
import com.fernando.myprojects.databinding.ItemProjectBinding
import com.fernando.myprojects.extension.TAG
import com.fernando.myprojects.helpers.CellClickListener
import com.fernando.myprojects.model.ProjectModel
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class MainAdapter @Inject constructor() : RecyclerView.Adapter<MainAdapter.MyViewHolder>(), Filterable {

    private val listBackup: MutableList<ProjectModel> = ArrayList()
    private var listFilter: MutableList<ProjectModel> = ArrayList()
    private lateinit var cellClickListener: CellClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFilter.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(listFilter[position])
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_fade_left)
    }

    fun setListener(cellClickListener: CellClickListener) {
        this.cellClickListener = cellClickListener
    }

    fun setProjects(newItems: List<ProjectModel>) {
        listBackup.clear()
        listFilter.clear()

        listBackup.addAll(newItems)
        listFilter.addAll(newItems)

        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val binding: ItemProjectBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(project: ProjectModel) {
            try {
                binding.tvTitle.text = project.title
                binding.tvDescription.text = project.description

                itemView.setOnClickListener {
                    cellClickListener.onCellClickListener(project)
                }

            } catch (e: Exception) {
                Log.e(TAG, "MyViewHolder:bind ${e.message}")
            }
        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val resultList: MutableList<ProjectModel> = ArrayList()

                val charSearch = constraint.toString()

                for (row in listBackup)
                    if ("${row.title.toLowerCase(Locale.ROOT)} ${row.description.toLowerCase(Locale.ROOT)}".contains(charSearch.toLowerCase(Locale.ROOT)))
                        resultList.add(row)

                listFilter = resultList

                val filterResults = FilterResults()
                filterResults.values = listFilter
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listFilter = (results?.values as MutableList<ProjectModel>)
                notifyDataSetChanged()
            }
        }
    }
}



