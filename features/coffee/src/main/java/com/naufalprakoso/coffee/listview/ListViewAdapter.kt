package com.naufalprakoso.coffee.listview

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import com.bumptech.glide.Glide
import com.naufalprakoso.coffee.R
import com.naufalprakoso.coffee.model.Coffee
import kotlinx.android.synthetic.main.item_coffee.view.*

class ListViewAdapter(
    private val context: Context
) : ListAdapter {

    private val coffees = arrayListOf<Coffee>()

    fun setCoffees(coffees: List<Coffee>) {
        this.coffees.clear()
        this.coffees.addAll(coffees)
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_coffee, null)
        val coffee = coffees[position]

        view.run {
            Glide.with(context).load(coffee.image).into(ivBook)
            tvName.text = coffee.name
        }

        return view
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getViewTypeCount(): Int {
        return coffees.size
    }

    override fun isEnabled(position: Int): Boolean {
        return true
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {

    }

    override fun getCount(): Int {
        return coffees.size
    }
}