package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Merge Sorted Array` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    @Test
    fun test1() {
//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        merge(nums1, 3, intArrayOf(2, 5, 6), 3)

        Assertions.assertArrayEquals(nums1, intArrayOf(1, 2, 2, 3, 5, 6))
    }


    private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var lastIndex = n + m - 1

        while (i >= 0 || j >= 0) {
            val x = if (i >= 0) nums1[i] else Int.MIN_VALUE
            val y = if (j >= 0) nums2[j] else Int.MIN_VALUE

            if (x >= y) {
                nums1[lastIndex--] = x
                i--
            }else {
                nums1[lastIndex--] = y
                j--
            }
        }
    }
}