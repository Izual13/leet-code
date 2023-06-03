package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Find subarray with given sum (Handles Negative Numbers)` {


    @Test
    fun test1() {
        val (a, b) = subArraySum(intArrayOf(4, 3, 5, 7, 8), 12)
        Assertions.assertEquals(0, a)
        Assertions.assertEquals(2, b)
    }

    @Test
    fun test2() {
        val (a, b) = subArraySum(intArrayOf(10, 2, -2, -20, 10), 10)
        Assertions.assertEquals(0, a)
        Assertions.assertEquals(0, b)
    }

    @Test
    fun test3() {
        assertThrows(RuntimeException::class.java) {
            subArraySum(intArrayOf(1, 2, 3, 4), 15)
        }
    }


    private fun subArraySum(nums: IntArray, target: Int): IntArray {
        val cache = HashMap<Int, Int>()
        cache.put(0,0)
        var tmp = 0
        for (b in nums.indices) {
            tmp += nums[b]
            val a = cache[tmp - target]
            if (a != null) {
                return intArrayOf(a, b)
            }
            cache[tmp] = b
        }

        throw RuntimeException("!!")
    }

}