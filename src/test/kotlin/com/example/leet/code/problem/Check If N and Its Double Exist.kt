package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Check If N and Its Double Exist` {

    @Test
    fun test1() {
        Assertions.assertTrue(checkIfExist(intArrayOf(10, 2, 5, 3)))
    }


    @Test
    fun test2() {
        Assertions.assertFalse(checkIfExist(intArrayOf(-2, 0, 10, -19, 4, 6, -8)))
    }

    @Test
    fun test3() {
        Assertions.assertTrue(checkIfExist(intArrayOf(0, -2, 0, 10, -19, 4, 6, -8)))
    }


    private fun checkIfExist(arr: IntArray): Boolean {
        val set = HashSet<Int>()
        for (i in arr) {
            if (i.and(1) == 0) {
                if (!set.add(i) && i == 0) {
                    return true
                }
            }
        }

        for (i in arr) {
            if (set.contains(i * 2) && i != 0) {
                return true
            }
        }

        return false
    }
}