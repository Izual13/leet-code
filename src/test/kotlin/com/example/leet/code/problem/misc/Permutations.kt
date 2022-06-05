package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class Permutations {

    @Test
    fun test1() {
        Assertions.assertEquals(
            arrayListOf(
                arrayListOf(1, 2, 3), arrayListOf(1, 3, 2),
                arrayListOf(2, 1, 3), arrayListOf(2, 3, 1),
                arrayListOf(3, 2, 1), arrayListOf(3, 1, 2)
            ),
            permute(intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf(arrayListOf(1)), permute(intArrayOf(1)))
    }


    private fun permute(nums: IntArray, startIndex: Int = 0, result: ArrayList<List<Int>> = ArrayList()): List<List<Int>> {
        if (nums.size == startIndex + 1) {
            result.add(nums.toList())
            return result
        }

        for (i in startIndex until nums.size) {

            if (nums[startIndex] == nums[i]) {
                permute(nums, startIndex + 1, result)
                continue
            }

            swap(nums, startIndex, i)
            permute(nums, startIndex + 1, result)
            swap(nums, startIndex, i)
        }

        return result
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }
}