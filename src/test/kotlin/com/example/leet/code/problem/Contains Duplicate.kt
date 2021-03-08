package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Contains Duplicate` {

    @Test
    fun test1() {
        Assertions.assertEquals(true, containsDuplicate(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, containsDuplicate(intArrayOf(1, 2, 3, 4)))
    }

    private fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        for (i in nums) {
            if (!set.add(i)) {
                return true
            }
        }
        return false
    }
}