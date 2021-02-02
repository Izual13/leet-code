package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Combination Sum II` {

    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(arrayListOf(1, 1, 6), arrayListOf(1, 2, 5), arrayListOf(1, 7), arrayListOf(2, 6)), combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf(arrayListOf(1, 2, 2), arrayListOf(5)), combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
    }

    private fun combinationSum2(
        candidates: IntArray,
        target: Int,
        startIndex: Int = 0,
        tmp: Int = 0,
        tmpArray: ArrayList<Int> = ArrayList(),
        result: HashSet<List<Int>> = LinkedHashSet()
    ): List<List<Int>> {
        if (tmp == target) {
            result.add(ArrayList(tmpArray))
        } else if (tmp > target) {
            return result.toList()
        }

        if (tmp == 0) {
            candidates.sort()
        }

        for (i in startIndex..candidates.lastIndex) {
            val element = candidates[i]
            tmpArray.add(element)
            combinationSum2(candidates, target, i + 1, tmp + element, tmpArray, result)
            tmpArray.removeAt(tmpArray.lastIndex)
        }

        return result.toList()
    }

}