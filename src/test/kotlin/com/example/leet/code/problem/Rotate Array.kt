package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Rotate Array` {

    @Test
    fun test1() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        rotate(arr, 3)

        Assertions.assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), arr)
    }

    @Test
    fun test2() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        rotate(arr, 7)

        Assertions.assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), arr)
    }


    private fun rotate(nums: IntArray, k: Int): Unit {
        if (k == 1) {
            return
        }

        val n = k % nums.size

        if (n == 0) {
            return
        }

        nums.reverse()

        nums.reverse(0, n)
        nums.reverse(n, nums.lastIndex + 1)
    }
}