package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Find First and Last Position of Element in Sorted Array` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(3, 4), searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8))
    }

    @Test
    fun test2() {
        Assertions.assertArrayEquals(intArrayOf(-1, -1), searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6))
    }

    private fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(searchStart(nums, target), searchEnd(nums, target))
    }

    private fun searchStart(nums: IntArray, target: Int, index: Int = -1, start: Int = 0, end: Int = nums.lastIndex): Int {
        if (start > end) {
            return index
        }

        val mid = start + (end - start) / 2

        return when {
            nums[mid] == target -> searchStart(nums, target, mid, start, mid - 1)
            nums[mid] > target -> searchStart(nums, target, index, start, mid - 1)
            else -> searchStart(nums, target, index, mid + 1, end)
        }
    }

    private fun searchEnd(nums: IntArray, target: Int, index: Int = -1, start: Int = 0, end: Int = nums.lastIndex): Int {
        if (start > end) {
            return index
        }

        val mid = start + (end - start) / 2

        return when {
            nums[mid] == target -> searchEnd(nums, target, mid, mid + 1, end)
            nums[mid] < target -> searchEnd(nums, target, index, mid + 1, end)
            else -> searchEnd(nums, target, index, start, mid - 1)
        }
    }

}