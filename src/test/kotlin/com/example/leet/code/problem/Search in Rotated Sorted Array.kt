package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Search in Rotated Sorted Array` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(-1, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(-1, search(intArrayOf(1), 0))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(2, search(intArrayOf(5, 1, 3), 3))
    }


    private fun search(nums: IntArray, target: Int, start: Int = 0, end: Int = nums.lastIndex): Int {
        if (start > end) {
            return -1
        }

        val mid = (end - start) / 2 + start

        if (nums[mid] == target) {
            return mid
        } else if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return search(nums, target, start, mid - 1)
            } else {
                return search(nums, target, mid + 1, end)
            }
        } else {
            if (target > nums[mid] && target <= nums[end]) {
                return search(nums, target, mid + 1, end)
            } else {
                return search(nums, target, start, mid - 1)
            }
        }
    }

}