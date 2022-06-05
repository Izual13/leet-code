package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

@Suppress("ClassName")
class `Insert Interval` {
    @Test
    fun test1() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(1, 5), intArrayOf(6, 9)), insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)))
    }

    @Test
    fun test2() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(1, 5)), insert(arrayOf(), intArrayOf(1, 5)))
    }

    @Test
    fun test3() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(1, 5)), insert(arrayOf(intArrayOf(1, 5)), intArrayOf(2, 3)))
    }


    @Test
    fun test4() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(0, 0), intArrayOf(1, 5)), insert(arrayOf(intArrayOf(1, 5)), intArrayOf(0, 0)))
    }

    @Test
    fun test5() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(0, 6)), insert(arrayOf(intArrayOf(1, 5)), intArrayOf(0, 6)))
    }

    @Test
    fun test6() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(3, 5), intArrayOf(6, 6), intArrayOf(12, 15)), insert(arrayOf(intArrayOf(3, 5), intArrayOf(12, 15)), intArrayOf(6, 6)))
    }

    @Test
    fun test7() {
        Assertions.assertArrayEquals(arrayOf(intArrayOf(1, 5), intArrayOf(6, 9)), insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)))
    }


    private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf(newInterval)
        }

        val result = ArrayList<IntArray>()
        val size = intervals.size

        var i = 0

        while (i < size && newInterval[0] > intervals[i][1]) {
            result.add(intervals[i])
            i++
        }


        while (i < size && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i++
        }
        result.add(newInterval)

        while (i < size) {
            result.add(intervals[i])
            i++
        }

        return result.toTypedArray()
    }
}
