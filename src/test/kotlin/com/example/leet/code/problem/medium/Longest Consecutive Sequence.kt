package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import kotlin.math.max


@Suppress("ClassName")
class `Longest Consecutive Sequence` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(9, longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    }

    @Test
    @Timeout(2)
    fun test3() {
        val result = IntArray(100000) { it }

        Assertions.assertEquals(100000, longestConsecutive(result))
    }


    private fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()
        for (i in nums) {
            set.add(i)
        }

        var result = 0

        for (i in set) {
            if (set.contains(i - 1)) {
                continue
            }

            var tmp = 1
            var value = i + 1
            while (set.contains(value)) {
                tmp++
                value++
            }

            result = max(tmp, result)
        }

        return result
    }
}