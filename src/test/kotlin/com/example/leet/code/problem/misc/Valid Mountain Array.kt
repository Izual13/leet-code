package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Valid Mountain Array` {

    @Test
    fun test1() {
        Assertions.assertTrue(validMountainArray(intArrayOf(0, 3, 2, 1)))
    }


    @Test
    fun test2() {
        Assertions.assertFalse(validMountainArray(intArrayOf(1, 2)))
    }

    @Test
    fun test3() {
        Assertions.assertFalse(validMountainArray(intArrayOf(0, 3, 3, 3)))
    }

    @Test
    fun test4() {
        Assertions.assertFalse(validMountainArray(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)))
    }


    private fun validMountainArray(arr: IntArray): Boolean {
        val lastIndex = arr.lastIndex
        if (lastIndex < 2) {
            return false
        }

        var i = 0
        while (i + 1 <= lastIndex && arr[i] < arr[i + 1]) {
            i++
        }

        if (i == lastIndex || i == 0) {
            return false
        }

        while (i + 1 <= lastIndex && arr[i] > arr[i + 1]) {
            i++
        }

        if (i != lastIndex) {
            return false
        }

        return true
    }
}