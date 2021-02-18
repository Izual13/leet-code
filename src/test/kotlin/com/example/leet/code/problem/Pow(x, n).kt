package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.text.DecimalFormat




@Suppress("ClassName")
class `Pow(x, n)` {

    @Test
    fun test1() {
        Assertions.assertEquals(0.0, myPow(0.0, 0))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1 / 4.0, myPow(2.0, -2))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(81.0, myPow(3.0, 4))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(4.0, myPow(2.0, 2))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(1.0, myPow(1.0, 2147483647))
    }

    @Test
    fun test6() {
        Assertions.assertEquals(0.0, myPow(2.00000, -2147483648))
    }

    @Test
    fun test7() {
        Assertions.assertEquals(0.0000254, myPow(34.00515, -3), 0.000001)
    }


    private fun myPow(x: Double, n: Int): Double {
        return when {
            x == 0.0 || x == 1.0 -> x
            n == 0 -> 1.0
            n < 0 -> {
                var result = x
                for (i in -2 downTo n) {
                    result *= x
                }
                return 1 / result
            }
            else -> {
                var result = x
                for (i in 1 until n) {
                    result *= x
                }

                return result
            }
        }
    }

}