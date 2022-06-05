package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Two Sum` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun test2() {
        Assertions.assertArrayEquals(intArrayOf(1, 2), twoSum(intArrayOf(3, 2, 4), 6))
    }


    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val x = target - nums[i]
            if (map.contains(x)) {
                return intArrayOf(map[x]!!, i)
            }

            map[nums[i]] = i
        }

        return intArrayOf()
    }
}