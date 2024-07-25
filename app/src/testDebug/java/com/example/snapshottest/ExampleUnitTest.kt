package com.example.snapshottest

import androidx.constraintlayout.widget.ConstraintLayout
import app.cash.paparazzi.Paparazzi
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun launchView() {
        val view = paparazzi.inflate<ConstraintLayout>(R.layout.activity_main)
        paparazzi.snapshot(view)
    }
}