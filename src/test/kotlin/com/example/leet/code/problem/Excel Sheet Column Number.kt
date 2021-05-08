package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        return s.asSequence().map { it.code - 64 }.reduce { acc, e -> acc * 26 + e }
    }
}