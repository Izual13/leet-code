package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Two Sum II - Input array is sorted` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(1, 2), twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun test2() {
        Assertions.assertArrayEquals(intArrayOf(1, 3), twoSum(intArrayOf(2, 3, 4), 6))
    }


    private fun twoSum(numbers: IntArray, target: Int): IntArray {

        for (i in 0 until numbers.lastIndex) {
            val secondIndex = Arrays.binarySearch(numbers, i + 1, numbers.size, target - numbers[i])
            if (secondIndex > 0) {
                return intArrayOf(i + 1, secondIndex + 1)
            }
        }
        return intArrayOf(0, 0)
    }
}