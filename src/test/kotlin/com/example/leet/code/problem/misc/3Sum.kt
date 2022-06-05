package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `3Sum` {

    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(arrayListOf(-1, -1, 2), arrayListOf(-1, 0, 1)), threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf(arrayListOf(-1, -1, 2)), threeSum(intArrayOf(-1, -1, 2)))
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()


        nums.sort()

        for (i in nums.indices) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue
            }

            val n1 = nums[i]

            var start = i + 1
            var end = nums.size - 1
            while (start < end) {
                val n2 = nums[start]
                val n3 = nums[end]

                if (n1 + n2 + n3 == 0) {
                    result.add(arrayListOf(n1, n2, n3))
                    start++
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++
                    }
                } else if (n1 + n2 < -n3) {
                    start++
                } else {
                    end--
                }
            }

        }


        return result.toList()
    }
}