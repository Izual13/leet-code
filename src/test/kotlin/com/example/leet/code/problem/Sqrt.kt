package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class Sqrt {


    @Test
    fun test1() {
        Assertions.assertEquals(2, mySqrt(4))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(2, mySqrt(8))
    }

    private fun mySqrt(x: Int): Int {
        if (x == 1) {
            return 1
        }


        return Math.floor(Math.sqrt(x.toDouble())).toInt()
    }
}