package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Remove Element` {
    @Test
    fun test1() {
        val nums = intArrayOf(0,1,2,2,3,0,4,2)
        Assertions.assertEquals(removeElement(nums, 2), 5)
        Assertions.assertEquals(nums[0], 0)
        Assertions.assertEquals(nums[1], 1)
        Assertions.assertEquals(nums[2], 3)
        Assertions.assertEquals(nums[3], 0)
        Assertions.assertEquals(nums[4], 4)
    }


    private fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var count = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[count++] = nums[i]
            }
        }
        return count
    }
}