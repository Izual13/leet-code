package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Sort Array By Parity` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(4, 2, 1, 3), sortArrayByParity(intArrayOf(3, 1, 2, 4)))
    }

    private fun sortArrayByParity(A: IntArray): IntArray {
        var start = 0
        var end = A.lastIndex

        while (start != end) {
            val i = A[start]
            if (i.and(1) == 0) {
                A[start++] = i
            } else {
                A[start] = A[end]
                A[end--] = i
            }
        }

        return A
    }
}