package com.naufalprakoso.benchmark

import android.widget.TextView
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.naufalprakoso.coffee.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComplexLayoutBenchmark {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @UiThreadTest
    @Test
    fun testConstraintLayout_ToAccessComponent() {
        activityRule.activity.let {
            it.setContentView(R.layout.activity_complex_constraint_layout)
            benchmarkRule.measureRepeated {
                it.findViewById<TextView>(R.id.tvNested).text = "Hello World"
                it.findViewById<TextView>(R.id.tvNested2).text = "Hello World 2"
            }
        }
    }

    @UiThreadTest
    @Test
    fun testLinearLayout_ToAccessComponent() {
        activityRule.activity.let {
            it.setContentView(R.layout.activity_complex_linear_layout)
            benchmarkRule.measureRepeated {
                it.findViewById<TextView>(R.id.tvNested).text = "Hello World"
                it.findViewById<TextView>(R.id.tvNested2).text = "Hello World 2"
            }
        }
    }
}