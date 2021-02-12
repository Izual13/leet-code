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


    val list = ('A'..'Z').toList()

    private fun titleToNumber(s: String): Int {
        var result = 0
        val lastIndex = s.lastIndex
        for (i in s.indices) {
            val element = s[i]
            val index = list.indexOf(element)
            val tmp = 26.toDouble().pow(lastIndex - i) * (index + 1)
            result += tmp.toInt()
        }
        return result
    }
}