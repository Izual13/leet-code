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

    @Test
    fun test3() {
        Assertions.assertArrayEquals(intArrayOf(0, 0), searchRange(intArrayOf(1, 2, 3), 1))
    }

    private fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(searchStart(nums, target), searchEnd(nums, target))
    }

    private fun searchStart(nums: IntArray, target: Int): Int {
        var index = -1
        var start = 0
        var end = nums.lastIndex


        while (start <= end) {
            val mid = start + (end - start) / 2

            if (nums[mid] == target) {
                index = mid
            }

            if (nums[mid] >= target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return index
    }

    private fun searchEnd(nums: IntArray, target: Int): Int {
        var index = -1
        var start = 0
        var end = nums.lastIndex


        while (start <= end) {
            val mid = start + (end - start) / 2

            if (nums[mid] == target) {
                index = mid
            }

            if (nums[mid] <= target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return index
    }

}