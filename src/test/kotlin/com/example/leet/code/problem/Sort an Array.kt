package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Sort an Array` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(1, 2, 3, 5), sortArray(intArrayOf(5, 2, 3, 1)))
    }

    private fun sortArray(nums: IntArray, start: Int = 0, end: Int = nums.lastIndex): IntArray {
        if (start >= end) {
            return nums
        }

        val mid = (start + end) / 2

        sortArray(nums, start, mid)
        sortArray(nums, mid + 1, end)

        val tmp = IntArray(end - start + 1)
        var i = 0
        var f1 = start
        var f2 = mid + 1

        while (f1 != mid + 1 || f2 != end + 1) {
            if (f1 == mid + 1) {
                tmp[i++] = nums[f2++]
            } else if (f2 == end + 1) {
                tmp[i++] = nums[f1++]
            } else if (nums[f1] >= nums[f2]) {
                tmp[i++] = nums[f2++]
            } else {
                tmp[i++] = nums[f1++]
            }
        }

        var tStart = start
        for (x in 0 until i) {
            nums[tStart++] = tmp[x]
        }

        return nums
    }
}