package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Merge Intervals` {
    @Test
    fun test1() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)), merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))))
    }

    @Test
    fun test2() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)), merge(arrayOf(intArrayOf(2, 6), intArrayOf(1, 3), intArrayOf(8, 10), intArrayOf(15, 18))))
    }

    @Test
    fun test3() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(1, 4)), merge(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
    }


    private fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) {
            return intervals
        }

        intervals.sortBy { it[0] }

        val result = ArrayList<IntArray>()

        var tmp: IntArray = intervals[0]
        for (i in 1..intervals.lastIndex) {
            val interval = intervals[i]

            if (tmp[1] >= interval[0]) {
                tmp[1] = max(tmp[1], interval[1])
            } else {
                result.add(intArrayOf(*tmp))
                tmp = interval
            }
        }

        //add last
        result.add(intArrayOf(*tmp))

        return result.toTypedArray()
    }
}
