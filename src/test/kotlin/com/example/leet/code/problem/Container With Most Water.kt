package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

@Suppress("ClassName")
class `Container With Most Water` {


    @Test
    fun test1() {
        Assertions.assertEquals(49, maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, maxArea(intArrayOf(1, 1)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(16, maxArea(intArrayOf(4, 3, 2, 1, 4)))
    }

    fun maxArea(height: IntArray): Int {
        var result = 0
        var start = 0
        var end = height.size - 1

        while (start < end) {
            val l = height[start]
            val r = height[end]
            val tmp = min(l, r) * (end - start)
            result = max(tmp, result)

            if (l > r) {
                end--
            } else {
                start++
            }
        }

        return result
    }

}