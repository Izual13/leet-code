package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.pow

@Suppress("ClassName")
class `Excel Sheet Column Number` {

    @Test
    fun test1() {
        Assertions.assertEquals(28, titleToNumber("AB"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, titleToNumber("A"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(701, titleToNumber("ZY"))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(26, titleToNumber("Z"))
    }

    private fun titleToNumber(s: String): Int {
        var result = 0
        var lastIndex = s.lastIndex
        for (e in s) {
            val index = e.toInt() - 64
            val tmp = 26.toDouble().pow(lastIndex--) * index
            result += tmp.toInt()
        }
        return result
    }
}