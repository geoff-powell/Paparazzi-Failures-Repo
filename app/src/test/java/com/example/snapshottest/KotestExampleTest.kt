package com.example.snapshottest

import io.kotest.matchers.shouldBe
import io.kotest.runner.junit4.StringSpec

class KotestExampleTest : StringSpec(
    {
        "should return 4" {
            2 + 2 shouldBe 4
        }
    }
)