package com.example.snapshottest.features.problemfeature

import androidx.constraintlayout.widget.ConstraintLayout
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class TestViewScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun inflateAViewAndVerifySomething() {
        val view = paparazzi.inflate<ConstraintLayout>(R.layout.v_test)
        paparazzi.snapshot(view)
    }
}