package com.naufalprakoso.coffee.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufalprakoso.coffee.R
import com.naufalprakoso.coffee.model.Coffee
import kotlinx.android.synthetic.main.item_coffee.view.*

class RecyclerViewAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val coffees = arrayListOf<Coffee>()

    fun setCoffees(coffees: List<Coffee>) {
        this.coffees.clear()
        this.coffees.addAll(coffees)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_coffee,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = coffees.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindBook(context, coffees[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindBook(context: Context, coffee: Coffee) {
            Glide.with(context).load(coffee.image).into(itemView.ivBook)
            itemView.tvName.text = coffee.name
        }
    }

}