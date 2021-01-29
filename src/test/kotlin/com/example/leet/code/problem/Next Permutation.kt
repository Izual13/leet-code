package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Next Permutation` {

    @Test
    fun test1() {
        val nums = intArrayOf(3, 2, 1)
        nextPermutation(nums)
        Assertions.assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun test2() {
        val nums = intArrayOf(1, 1, 5)
        nextPermutation(nums)
        Assertions.assertArrayEquals(intArrayOf(1, 5, 1), nums)
    }

    @Test
    fun test3() {
        val nums = intArrayOf(1, 2, 3)
        nextPermutation(nums)
        Assertions.assertArrayEquals(intArrayOf(1, 3, 2), nums)
    }

    @Test
    fun test4() {
        val nums = intArrayOf(0, 1, 2, 5, 3, 3, 0)
        nextPermutation(nums)
        Assertions.assertArrayEquals(intArrayOf(0, 1, 3, 0, 2, 3, 5), nums)
    }

    @Test
    fun test5() {
        val nums = intArrayOf(1, 3, 2)
        nextPermutation(nums)
        Assertions.assertArrayEquals(intArrayOf(2, 1, 3), nums)
    }


    private fun nextPermutation(nums: IntArray): Unit {
        var min = -1
        var max = nums.size
        var lastIndex = nums.lastIndex

        for (i in lastIndex downTo 1) {
            if (nums[i - 1] < nums[i]) {
                min = i - 1
                break
            }
        }

        if (min == -1) {
            nums.reverse()
            return
        }

        for (i in lastIndex downTo 0) {
            if (nums[min] < nums[i]) {
                max = i
                break
            }
        }

        //swap
        swap(nums, min, max)

        //reverse
        for (i in min + 1..(lastIndex - min) / 2 + min) {
            swap(nums, lastIndex--, i)
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int){
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }
}