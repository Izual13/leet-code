package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.StringBuilder

@Suppress("ClassName")
class `Integer to Roman` {
    @Test
    fun test1() {
        Assertions.assertEquals("LVIII", intToRoman(58))
    }

    @Test
    fun test2() {
        Assertions.assertEquals("MCMXCIV", intToRoman(1994))
    }

    val roman: Map<Int, String> = linkedMapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
    )

    private fun intToRoman(num: Int): String {
        var reminder = num
        val result = StringBuilder()
        roman.forEach { (t, u) ->
            val tmp = reminder / t
            if (tmp > 0) {
                result.append(u.repeat(tmp))
            }
            reminder %= t
        }
        return result.toString()
    }

    private fun intToRoman2(num: Int): String {
        var reminder = num
        val result = StringBuilder()
        roman.forEach { (t, u) ->
            while (reminder >= t) {
                reminder -= t
                result.append(u)
            }
        }
        return result.toString()
    }
}