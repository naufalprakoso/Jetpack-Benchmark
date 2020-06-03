package com.naufalprakoso.benchmark

import android.widget.ListView
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.recyclerview.widget.RecyclerView
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.naufalprakoso.coffee.getLastChild
import com.naufalprakoso.coffee.listview.ListViewActivity
import com.naufalprakoso.coffee.recyclerview.RecyclerViewActivity
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListBenchmark {
    @get:Rule
    val listViewRule = ActivityTestRule(ListViewActivity::class.java)

    @get:Rule
    val recyclerViewRule = ActivityTestRule(RecyclerViewActivity::class.java)

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @UiThreadTest
    @Test
    fun testListView_ScrollToTheLastItem() {
        listViewRule.activity.let {
            val listView = it.findViewById<ListView>(R.id.lvCoffees)
            benchmarkRule.measureRepeated {
                listViewRule.activity.runOnUiThread {
                    listView.scrollBy(0, listView.getLastChild().height)
                }
            }
        }
    }

    @UiThreadTest
    @Test
    fun testRecyclerView_ScrollToTheLastItem() {
        recyclerViewRule.activity.let {
            val recyclerView = it.findViewById<RecyclerView>(R.id.rvCoffees)
            benchmarkRule.measureRepeated {
                recyclerViewRule.activity.runOnUiThread {
                    recyclerView.scrollBy(0, recyclerView.getLastChild().height)
                }
            }
        }
    }

    @After
    fun teardown() {
        listViewRule.finishActivity()
        recyclerViewRule.finishActivity()
    }
}