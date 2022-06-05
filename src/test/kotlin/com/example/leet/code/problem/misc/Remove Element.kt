package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Remove Element` {
    @Test
    fun test1() {
        val nums = intArrayOf(0,1,2,2,3,0,4,2)
        Assertions.assertEquals(5, removeElement(nums, 2))
        Assertions.assertEquals(0, nums[0])
        Assertions.assertEquals(1, nums[1])
        Assertions.assertEquals(3, nums[2])
        Assertions.assertEquals(0, nums[3])
        Assertions.assertEquals(4, nums[4])
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