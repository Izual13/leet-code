package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Excel Sheet Column Title` {

    @Test
    fun test1() {
        Assertions.assertEquals("AB", convertToTitle(28))
    }

    @Test
    fun test2() {
        Assertions.assertEquals("A", convertToTitle(1))
    }

    @Test
    fun test3() {
        Assertions.assertEquals("ZY", convertToTitle(701))
    }

    @Test
    fun test4() {
        Assertions.assertEquals("Z", convertToTitle(26))
    }


    val list = ('A'..'Z').toList()

    private fun convertToTitle(n: Int): String {
        var tmp = n
        val result = StringBuilder()
        while (tmp != 0) {
            result.append(list[--tmp % 26])
            tmp /= 26

        }
        return result.reverse().toString()
    }

}