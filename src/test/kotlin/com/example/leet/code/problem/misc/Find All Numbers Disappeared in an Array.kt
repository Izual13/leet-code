package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs

@Suppress("ClassName")
class `Find All Numbers Disappeared in an Array` {

    @Test
    fun test1() {
        Assertions.assertEquals(listOf(5, 6), findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
    }


    private fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = ArrayList<Int>()

        if (nums.isEmpty()) {
            return result
        }

        for (i in nums.indices) {
            val num = abs(nums[i]) - 1
            if (nums[num] > 0) {
                nums[num] = -nums[num]
            }
        }

        for (i in nums.indices) {
            if (nums[i] > 0) {
                result.add(i + 1)
            }
        }

        return result
    }
}