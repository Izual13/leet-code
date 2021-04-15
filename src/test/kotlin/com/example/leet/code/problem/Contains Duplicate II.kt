package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

@Suppress("ClassName")
class `Contains Duplicate II` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    }


    @Test
    fun test2() {
        Assertions.assertEquals(false, containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    }


    private fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val list = HashSet<Int>()
        val map = HashMap<Int, IntArray>()

        for (i in nums.indices) {
            val num = nums[i]
            if (map.containsKey(num)) {
                list.add(num)
                val ints = map[num]
                if (ints!!.size == 1) {
                    map[num] = intArrayOf(i, i - ints[0])
                } else {
                    map[num] = intArrayOf(i, min(i - ints[0], ints[1]))
                }
            } else {
                map[num] = intArrayOf(i)
            }
        }

        for (i in list) {
            if (map[i]!![1] <= k) {
                return true
            }
        }

        return false
    }
}