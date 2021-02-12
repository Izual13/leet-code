package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Factorial Trailing Zeroes` {

    @Test
    fun test1() {
        Assertions.assertEquals(1, trailingZeroes(5))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(0, trailingZeroes(0))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(2, trailingZeroes(10))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(2, trailingZeroes(11))
    }


    @Test
    fun test5() {
        Assertions.assertEquals(7, trailingZeroes(30))
    }


    private fun trailingZeroes(n: Int): Int {
        if (n == 0) {
            return 0
        }

        var result = 0

        for (i in 1..n) {
            var tmp = i
            while (tmp % 5 == 0) {
                result++
                tmp /= 5
            }
        }

        return result
    }

}