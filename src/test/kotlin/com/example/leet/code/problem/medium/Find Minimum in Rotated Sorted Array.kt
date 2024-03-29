package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Find Minimum in Rotated Sorted Array` {

    @Test
    fun test1() {
        Assertions.assertEquals(0, findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, findMin(intArrayOf(3, 4, 5, 1, 2)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(11, findMin(intArrayOf(11, 13, 15, 17)))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(1, findMin(intArrayOf(3, 1, 2)))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(555, findMin(intArrayOf(555)))
    }

    @Test
    fun test6() {
        Assertions.assertEquals(1, findMin(intArrayOf(2, 1)))
    }


    private fun findMin(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }

        var start = 0
        var end = nums.lastIndex

        while (start < end) {
            val mid = start + (end - start) / 2

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid]
            } else if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return nums[start]
    }
}