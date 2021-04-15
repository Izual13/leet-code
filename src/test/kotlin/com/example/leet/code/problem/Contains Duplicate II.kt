package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Contains Duplicate II` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    }


    @Test
    fun test2() {
        Assertions.assertEquals(false, containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    }


    private fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            val num = nums[i]
            val v = map[num]
            if (v != null && i - v <= k) {
                return true
            } else {
                map[num] = i
            }
        }

        return false
    }
}