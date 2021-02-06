package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Permutations II` {

    @Test
    fun test1() {
        Assertions.assertEquals(
            arrayListOf(arrayListOf(1, 1, 2), arrayListOf(1, 2, 1), arrayListOf(2, 1, 1)), permuteUnique(intArrayOf(1, 1, 2))
        )
    }

    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf(arrayListOf(1)), permuteUnique(intArrayOf(1)))
    }


    @Test
    fun test3() {
        Assertions.assertEquals(
            arrayListOf(
                arrayListOf(1, 2, 3), arrayListOf(1, 3, 2),
                arrayListOf(2, 1, 3), arrayListOf(2, 3, 1),
                arrayListOf(3, 2, 1), arrayListOf(3, 1, 2)
            ),
            permuteUnique(intArrayOf(1, 2, 3))
        )
    }


    private fun permuteUnique(nums: IntArray): List<List<Int>> {
        return permuteUnique(nums, 0, LinkedHashSet()).toList()
    }

    private fun permuteUnique(nums: IntArray, startIndex: Int = 0, result: HashSet<List<Int>> = LinkedHashSet()): HashSet<List<Int>> {
        if (nums.size == startIndex + 1) {
            result.add(nums.toList())
            return result
        }

        for (i in startIndex until nums.size) {
            if (nums[startIndex] == nums[i]) {
                if (startIndex != i) {
                    continue
                }

                permuteUnique(nums, startIndex + 1, result)
                continue
            }
            swap(nums, startIndex, i)
            permuteUnique(nums, startIndex + 1, result)
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