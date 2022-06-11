package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Find the Duplicate Number` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(3, findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, findDuplicate(intArrayOf(3, 1, 3, 4, 2, 3)))
    }


    @Test
    fun test4() {
        Assertions.assertEquals(4, findDuplicate(intArrayOf(1, 4, 4, 2, 4)))
    }


    @Test
    fun test5() {
        Assertions.assertEquals(9, findDuplicate(intArrayOf(2, 5, 9, 6, 9, 3, 8, 9, 7, 1)))
    }


    private fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = nums[0]

        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return slow
    }
}