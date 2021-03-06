package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Third Maximum Number` {

    @Test
    fun test1() {
        Assertions.assertEquals(1, thirdMax(intArrayOf(3, 2, 1)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, thirdMax(intArrayOf(2, 2, 3, 1)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(2, thirdMax(intArrayOf(2, 1)))
    }


    private fun thirdMax(nums: IntArray): Int {
        val maxArray = Array<Int?>(3) { null }

        for (i in nums) {
            if (maxArray.contains(i)) {
                continue
            }

            if (maxArray[0] == null || maxArray[0]!! < i) {
                maxArray[2] = maxArray[1]
                maxArray[1] = maxArray[0]
                maxArray[0] = i
            } else if (maxArray[1] == null || maxArray[1]!! < i) {
                maxArray[2] = maxArray[1]
                maxArray[1] = i
            } else if (maxArray[2] == null || maxArray[2]!! < i) {
                maxArray[2] = i
            }
        }

        return if (maxArray[2] == null) maxArray[0]!! else maxArray[2]!!
    }
}