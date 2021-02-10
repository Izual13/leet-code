package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Two Sum II - Input array is sorted` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(1, 2), twoSum(intArrayOf(2, 7, 11, 15), 9))
    }


    private fun twoSum(numbers: IntArray, target: Int): IntArray {

        for (i in numbers.indices) {
            val a = numbers[i]
            for (j in i + 1..numbers.lastIndex) {
                val b = numbers[j]
                if (a + b == target) {
                    return intArrayOf(i + 1, j + 1)
                }
            }
        }
        return intArrayOf(0, 0)
    }
}