package com.naufalprakoso.coffee.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalprakoso.coffee.R
import com.naufalprakoso.coffee.model.Coffee
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerViewAdapter
    private val coffees = arrayListOf<Coffee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        initBooks()

        adapter = RecyclerViewAdapter(this)
        adapter.setCoffees(coffees)

        rvCoffees.layoutManager = LinearLayoutManager(this)
        rvCoffees.adapter = adapter
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
