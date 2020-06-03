package com.naufalprakoso.coffee.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufalprakoso.coffee.model.Coffee
import com.naufalprakoso.coffee.R
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var adapter: ListViewAdapter
    private val coffees = arrayListOf<Coffee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        initBooks()

        adapter = ListViewAdapter(this)
        adapter.setCoffees(coffees)

        lvCoffees.adapter = adapter
    }

    private fun initBooks() {
        val titles = resources.getStringArray(R.array.titles)
        val images = resources.getStringArray(R.array.images)

        repeat(500) {
            for (i in titles.indices) {
                val id = (i + 1) * (it + 1)
                coffees.add(
                    Coffee(
                        id,
                        titles[i],
                        images[i]
                    )
                )
            }
        }
    }

}
