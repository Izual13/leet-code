package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Roman to Integer` {
    @Test
    fun test1() {
        Assertions.assertEquals(romanToInt("LVIII"), 58)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(romanToInt("MCMXCIV"), 1994)
    }

    val roman: HashMap<Char, Int> = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000)

    private fun romanToInt(s: String): Int {
        var result = 0
        var tmp = 0
        for (i in (s.length - 1) downTo 0) {
            val current = roman[s[i]]
            if (current!! < tmp) {
                result -= current
            } else {
                result += current
            }
            tmp = current
        }
        return result
    }
}