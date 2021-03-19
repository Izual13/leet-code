package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class Subsets {

    @Test
    fun test1() {
        Assertions.assertEquals(
            arrayListOf(arrayListOf(), arrayListOf(1), arrayListOf(1, 2), arrayListOf(1, 2, 3), arrayListOf(1, 3), arrayListOf(2), arrayListOf(2, 3), arrayListOf(3)),
            subsets(intArrayOf(1, 2, 3))
        )
    }

    private fun subsets(nums: IntArray, start: Int = 0, current: ArrayList<Int> = arrayListOf(), result: ArrayList<ArrayList<Int>> = ArrayList()): List<List<Int>> {
        if (start == 0) {
            result.add(arrayListOf())
        }


        for (i in start..nums.lastIndex) {
            val tmp = ArrayList(current)
            tmp.add(nums[i])
            result.add(tmp)

            subsets(nums, i + 1, tmp, result)
        }

        return result
    }
}