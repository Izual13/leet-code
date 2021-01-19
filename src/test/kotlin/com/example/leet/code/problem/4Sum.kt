package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `4Sum` {

    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(arrayListOf(-2, -1, 1, 2), arrayListOf(-2, 0, 0, 2), arrayListOf(-1, 0, 0, 1)), fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf(arrayListOf(-3,-1,2,4)), fourSum(intArrayOf(-3, -1, 0, 2, 4, 5), 2))
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {

                val n1 = nums[i]
                val n2 = nums[j]

                var start = j + 1
                var end = nums.size - 1
                while (start < end) {
                    val n3 = nums[start]
                    val n4 = nums[end]

                    val tmp = n1 + n2 + n3 + n4
                    if (tmp == target) {
                        result.add(arrayListOf(n1, n2, n3, n4))
                        start++
                        while (nums[start] == nums[start - 1] && start < end) {
                            start++
                        }
                    } else if (tmp < target) {
                        start++
                    } else {
                        end--
                    }
                }

            }
        }


        return result.toList()
    }
}