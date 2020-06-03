package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Remove Duplicates from Sorted Array` {
    @Test
    fun test1() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        Assertions.assertEquals(removeDuplicates(nums), 5)
        Assertions.assertEquals(nums[0], 0)
        Assertions.assertEquals(nums[1], 1)
        Assertions.assertEquals(nums[2], 2)
        Assertions.assertEquals(nums[3], 3)
        Assertions.assertEquals(nums[4], 4)
    }


    private fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var count = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i]
            }
        }
        return count
    }
}