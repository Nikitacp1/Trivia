package com.task.trivia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.task.trivia.model.DetailsModel
import com.task.trivia.R

internal class GameAdapter(private var detailsList: List<DetailsModel>) :
        RecyclerView.Adapter<GameAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvCricketerAnswer: TextView = view.findViewById(R.id.tvCricketerAnswer)
        var tvColorSelected: TextView = view.findViewById(R.id.tvColorSelected)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val detailsModel = detailsList[position]
        holder.tvName.text = detailsModel.name
        holder.tvCricketerAnswer.text = detailsModel.cricketer
        holder.tvColorSelected.text = detailsModel.colors
    }
    override fun getItemCount(): Int {
        return detailsList.size
    }

    fun setResults(results: List<DetailsModel>) {
        detailsList = results
        notifyDataSetChanged()
    }
}