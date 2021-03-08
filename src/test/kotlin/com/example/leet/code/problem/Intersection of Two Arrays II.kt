package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Intersection of Two Arrays II` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(2, 2), intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }

    @Test
    fun test2() {
        Assertions.assertArrayEquals(intArrayOf(9, 4), intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)))
    }

    private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val result = ArrayList<Int>()
        val map = HashMap<Int, Int>()

        for (i in nums1) {
            val count = map.getOrDefault(i, 0)
            map[i] = count + 1
        }

        for (i in nums2) {
            val count = map.getOrDefault(i, 0)
            if (count > 0) {
                map[i] = count - 1
                result.add(i)
            }
        }

        return result.toIntArray()
    }
}