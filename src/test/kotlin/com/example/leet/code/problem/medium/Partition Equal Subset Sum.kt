package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

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
    @Timeout(2)
    fun test3() {
        val ints = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        Assertions.assertEquals(true, canPartition(ints))
    }

    @Test
    @Timeout(2)
    fun test4() {
        val ints = intArrayOf(1,2,5)
        Assertions.assertEquals(false, canPartition(ints))
    }


    private fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum.and(1) == 1) {
            return false
        }

        val half = sum / 2

        var set = HashSet<Int>()
        set.add(0)

        for (n in nums) {
            val newSet = HashSet<Int>()
            for (j in set) {
                val tmp = j + n
                if (half == tmp) {
                    return true
                }
                newSet.add(tmp)
                newSet.add(j)
            }
            set = newSet
        }

        return set.contains(half)
    }
}