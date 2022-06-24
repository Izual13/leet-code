package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Partition Equal Subset Sum` {

    @Test
    fun test1() {
        Assertions.assertEquals(true, canPartition(intArrayOf(1, 5, 11, 5)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, canPartition(intArrayOf(1, 2, 3, 5)))
    }

    @Test
    fun test3() {
        val ints = intArrayOf(
            100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
            100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
            100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
            100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
            100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97)
        Assertions.assertEquals(false, canPartition(ints))
    }


    private fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum.and(1) == 1) {
            return false
        }

        val half = sum / 2
        nums.sort()

        return find(nums, half)
    }

    private fun find(nums: IntArray, sum: Int): Boolean {
        if (sum == 0) {
            return true
        } else if (sum < 0) {
            return false
        }

        var set = HashSet<Int>()
        set.add(0)

        for (n in nums) {
            for (j in set) {
                val tmp = j + n
                if (sum == tmp) {
                    return true
                }
                val newSet = HashSet<Int>()
                newSet.add(tmp)
                newSet.add(j)
                set = newSet
            }
        }

        return false
    }
}