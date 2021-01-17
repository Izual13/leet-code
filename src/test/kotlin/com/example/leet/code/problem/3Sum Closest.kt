package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs

@Suppress("ClassName")
class `3Sum Closest` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(-1, threeSumClosest(intArrayOf(1, 1, -1, -1, 3), -1))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, threeSumClosest(intArrayOf(1, 1, -1, -1, 3), 3))
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var result = nums[0] + nums[1] + nums[2]


        nums.sort()

        for (i in 0..nums.size - 2) {
            var start = i + 1
            var end = nums.size - 1
            val n1 = nums[i]
            while (start < end) {
                val n2 = nums[start]
                val n3 = nums[end]
                val tmp = n1 + n2 + n3

                if (tmp > target) {
                    end--
                } else {
                    start++
                }

                if (abs(tmp - target) < abs(result - target)) {
                    result = tmp
                }
            }
        }


        return result
    }
}