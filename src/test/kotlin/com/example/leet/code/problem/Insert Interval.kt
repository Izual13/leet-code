package com.example.leet.code.problem

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
        var isInsert = false

        for (i in 0..intervals.lastIndex) {
            val interval = intervals[i]

            if (!isInsert && newInterval[1] < interval[0]) {
                result.add(intArrayOf(*newInterval))
                isInsert = true
            }

            if (!isInsert && (newInterval[0] in interval[0]..interval[1] || newInterval[1] in interval[0]..interval[1]
                        || interval[0] in newInterval[0]..newInterval[1] || interval[1] in newInterval[0]..newInterval[1])
            ) {
                interval[0] = min(newInterval[0], interval[0])
                interval[1] = max(newInterval[1], interval[1])
                isInsert = true
            }

            if (result.isNotEmpty()) {
                val lastInterval = result.last()
                if (interval[0] in lastInterval[0]..lastInterval[1] || interval[1] in lastInterval[0]..lastInterval[1]) {
                    lastInterval[0] = min(interval[0], lastInterval[0])
                    lastInterval[1] = max(interval[1], lastInterval[1])
                } else {
                    result.add(intArrayOf(*interval))
                }
            } else {
                result.add(intArrayOf(*interval))
            }
        }

        if (!isInsert) {
            result.add(intArrayOf(*newInterval))
        }

        return result.toTypedArray()
    }
}
