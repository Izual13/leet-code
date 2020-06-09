package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Plus One` {

    @Test
    fun test1() {
        Assertions.assertEquals(plusOne(intArrayOf(9, 9, 9))[0], 1)
        Assertions.assertEquals(plusOne(intArrayOf(9, 9, 9))[1], 0)
        Assertions.assertEquals(plusOne(intArrayOf(9, 9, 9))[2], 0)
        Assertions.assertEquals(plusOne(intArrayOf(9, 9, 9))[3], 0)
    }

    private fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] == 9) {
                digits[i] = 0
            } else {
                digits[i]++
                return digits
            }
        }

        val result = IntArray(digits.size + 1)
        System.arraycopy(digits, 0, result, 1, digits.size)
        result[0] = 1

        return result
    }
}