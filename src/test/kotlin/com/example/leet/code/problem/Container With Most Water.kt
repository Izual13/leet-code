package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

@Suppress("ClassName")
class `Container With Most Water` {


    @Test
    fun test1() {
        Assertions.assertEquals(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)), 49)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(maxArea(intArrayOf(1, 1)), 1)
    }

    @Test
    fun test3() {
        Assertions.assertEquals(maxArea(intArrayOf(4, 3, 2, 1, 4)), 16)
    }

    fun maxArea(height: IntArray): Int {
        var result = 0;

        for (i in height.indices) {
            for (j in i + 1 until height.size) {
                val tmp = min(height[i], height[j]) * (j - i)
                println("$i + $j = $tmp (" + min(height[i], height[j]) + ") (" + (j - i) + ")")
                result = max(tmp, result)
            }
        }

        return result
    }

}