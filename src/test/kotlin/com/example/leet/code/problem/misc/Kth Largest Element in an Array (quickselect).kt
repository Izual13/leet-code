package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Kth Largest Element in an Array (quickselect)` {

    @Test
    fun test1() {
        Assertions.assertEquals(5, findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(2, findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 5))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(6, findKthLargest(intArrayOf(6, 6), 1))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(3, findKthLargest(intArrayOf(3, 3, 3, 3, 3, 3, 3, 3, 3), 1))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(4, findKthLargest(intArrayOf(3, 3, 3, 3, 4, 3, 3, 3, 3), 1))
    }

    @Test
    fun test6() {
        Assertions.assertEquals(3, findKthLargest(intArrayOf(3, 3, 3, 3, 3, 3, 3, 3, 3), 8))
    }

    @Test
    fun test7() {
        Assertions.assertEquals(3, findKthLargest(intArrayOf(3, 3, 3, 3, 4, 3, 3, 3, 3), 9))
    }

    private fun findKthLargest(nums: IntArray, k: Int, start: Int = 0, end: Int = nums.lastIndex): Int {
        val pivot = nums[end]
        if (start == end) {
            return pivot
        }

        var i = start
        var j = start
        while (j != end) {
            if (nums[j] > pivot) {
                swap(nums, i, j)
                i++
                j++
            } else {
                j++
            }
        }
        swap(nums, i, end)

        when {
            k == i + 1 -> return pivot
            k > i + 1 -> {
                if (i == start) {
                    return findKthLargest(nums, k, start + 1, end)
                }
                return findKthLargest(nums, k, i + 1, end)
            }
            else -> return findKthLargest(nums, k, start, i - 1)

        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }
}