package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Combination Sum` {


    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(arrayListOf(2, 2, 2, 2), arrayListOf(2, 3, 3), arrayListOf(3, 5)), combinationSum(intArrayOf(2, 3, 5), 8))
    }

    private fun combinationSum(
        candidates: IntArray,
        target: Int,
        startIndex: Int = 0,
        tmpArray: ArrayList<Int> = ArrayList(),
        result: ArrayList<List<Int>> = ArrayList()
    ): List<List<Int>> {
        if (0 == target) {
            result.add(ArrayList(tmpArray))
            return result
        } else if (target < 0) {
            return result
        }

        for (i in startIndex..candidates.lastIndex) {
            val element = candidates[i]
            tmpArray.add(element)
            combinationSum(candidates, target - element, i, tmpArray, result)
            tmpArray.removeAt(tmpArray.lastIndex)
        }

        return result
    }

}