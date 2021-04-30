package com.example.leet.code.problem

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


    private fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        val cacheX = ArrayList<Int>(arrayListOf(1, x))
        val cacheY = ArrayList<Int>(arrayListOf(1, y))
        val result = HashSet<Int>()
        for (i in 0..bound) {

            if (cacheX.lastIndex < i) {
                cacheX.add(cacheX[cacheX.lastIndex] * x)
            }

            if (cacheX[i] + 1 > bound) {
                break
            }

            for (j in 0..bound) {
                if (cacheY.lastIndex < j) {
                    cacheY.add(cacheY[cacheY.lastIndex] * y)
                }

                if (cacheX[i] + cacheY[j] > bound) {
                    break
                } else {
                    result.add(cacheY[j] + cacheX[i])
                }

                if (y == 1) {
                    break;
                }
            }

            if (x == 1) {
                break;
            }
        }

        return result.toList()
    }
}