package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs

@Suppress("ClassName")
class `Find All Numbers Disappeared in an Array` {

    @Test
    fun test1() {
        Assertions.assertEquals(listOf(5, 6), findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
    }


    private fun findDisappearedNumbers(nums: IntArray): List<Int> {
        if(nums.isEmpty()){
            return emptyList()
        }

        var findZero = false

        for (i in nums.indices) {
            val num = abs(nums[i]) - 1
            if (nums[num] >= 0) {
                nums[num] = -nums[num]
                if (num == 0) {
                    findZero = true
                }
            }
        }

        val result = ArrayList<Int>()

        if (!findZero) {
            result.add(1)
        }

        for (i in 1..nums.lastIndex) {
            if (nums[i] > 0) {
                result.add(i + 1)
            }
        }

        return result
    }
}