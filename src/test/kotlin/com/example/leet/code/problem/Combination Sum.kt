package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Combination Sum` {


    //[[2,2,2,2],[2,3,3],[3,5]]
    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(arrayListOf(2, 2, 2, 2), arrayListOf(2, 3, 3), arrayListOf(3, 5)), combinationSum(intArrayOf(2, 3, 5), 8))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(-1, combinationSum(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(-1, combinationSum(intArrayOf(1), 0))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(2, combinationSum(intArrayOf(5, 1, 3), 3))
    }


    private fun combinationSum(
        candidates: IntArray,
        target: Int,
        startIndex: Int = 0,
        tmp: Int = 0,
        tmpArray: ArrayList<Int> = ArrayList(),
        result: ArrayList<List<Int>> = ArrayList()
    ): List<List<Int>> {
        if (tmp == target) {
            result.add(ArrayList(tmpArray))
        } else if (tmp > target) {
            return result
        }


        for (i in startIndex..candidates.lastIndex) {
            val element = candidates[i]
            tmpArray.add(element)
            combinationSum(candidates, target, i, tmp + element, tmpArray, result)
            tmpArray.removeAt(tmpArray.lastIndex)
        }

        return result
    }

}