package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Powerful Integers` {

    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(2, 3, 4, 5, 7, 9, 10), powerfulIntegers(2, 3, 10))
    }


    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf(2, 4, 6, 8, 10, 14), powerfulIntegers(3, 5, 15))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(arrayListOf(2), powerfulIntegers(1, 1, 15))
    }


    private fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        val result = HashSet<Int>()
        var i = 1
        while (i <= bound) {

            var j = 1
            while (i + j <= bound) {
                result.add(i + j)

                j *= y

                if (y == 1) {
                    break;
                }
            }
            i *= x

            if (x == 1) {
                break;
            }
        }

        return result.toList()
    }
}