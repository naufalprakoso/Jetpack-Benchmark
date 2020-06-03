package com.naufalprakoso.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.naufalprakoso.coffee.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Benchmark, which will execute on an Android device.
 *
 * The body of [BenchmarkRule.measureRepeated] is measured in a loop, and Studio will
 * output the result. Modify your code to see how it affects performance.
 */
@RunWith(AndroidJUnit4::class)
class InflateLayoutBenchmark {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @UiThreadTest
    @Test
    fun testInflateConstraintLayout() {
        benchmarkRule.measureRepeated {
            activityRule.activity.setContentView(R.layout.sample_constraint_layout)
        }
    }

    @UiThreadTest
    @Test
    fun testInflateLinearLayout() {
        benchmarkRule.measureRepeated {
            activityRule.activity.setContentView(R.layout.sample_linear_layout)
        }
    }

    @UiThreadTest
    @Test
    fun testInflateRelativeLayout() {
        benchmarkRule.measureRepeated {
            activityRule.activity.setContentView(R.layout.sample_relative_layout)
        }
    }
}