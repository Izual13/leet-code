package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Replace Elements with Greatest Element on Right Side` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(18, 6, 6, 6, 1, -1), replaceElements(intArrayOf(17, 18, 5, 4, 6, 1)))
    }

    private fun replaceElements(arr: IntArray): IntArray {
        if (arr.isEmpty()) {
            return arr
        }

        var maxValue = arr.last()
        arr[arr.lastIndex] = -1

        for (i in arr.lastIndex - 1 downTo 0) {
            val tmp = maxValue
            maxValue = max(maxValue, arr[i])
            arr[i] = tmp
        }

        return arr
    }
}