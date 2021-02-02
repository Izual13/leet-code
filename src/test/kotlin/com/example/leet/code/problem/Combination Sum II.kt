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
        tmpArray: ArrayList<Int> = ArrayList(),
        result: HashSet<List<Int>> = LinkedHashSet()
    ): List<List<Int>> {
        if (target == 0) {
            result.add(ArrayList(tmpArray))
            return result.toList()
        } else if (target < 0) {
            return result.toList()
        }

        if (tmpArray.isEmpty()) {
            candidates.sort()
        }

        for (i in startIndex..candidates.lastIndex) {
            val element = candidates[i]
            tmpArray.add(element)
            combinationSum2(candidates, target - element, i + 1, tmpArray, result)
            tmpArray.removeAt(tmpArray.lastIndex)
        }

        return result.toList()
    }

}