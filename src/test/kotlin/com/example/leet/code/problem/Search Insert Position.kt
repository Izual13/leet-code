package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Search Insert Position` {


    @Test
    fun test1() {
        Assertions.assertEquals(searchInsert(intArrayOf(1, 3, 5, 6), 5), 2)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(searchInsert(intArrayOf(1, 3, 5, 6), 7), 4)
    }

    @Test
    fun test3() {
        Assertions.assertEquals(searchInsert(intArrayOf(1, 3, 5, 6), 0), 0)
    }

    @Test
    fun test4() {
        Assertions.assertEquals(searchInsert(intArrayOf(1), 1), 0)
    }

    private fun searchInsert(nums: IntArray, target: Int): Int {
        val binarySearch = nums.binarySearch(target)
        if (binarySearch >= 0) {
            return binarySearch
        }
        return -1 * (binarySearch + 1)
    }
}