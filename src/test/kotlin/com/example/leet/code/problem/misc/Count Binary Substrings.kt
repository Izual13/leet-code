package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Count Binary Substrings` {

    @Test
    fun test1() {
        Assertions.assertEquals(6, countBinarySubstrings("00110011"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(4, countBinarySubstrings("10101"))
    }


    private fun countBinarySubstrings(s: String): Int {
        var result = 0
        for (i in s.indices) {
            val main = s[i]
            for (j in i downTo 0) {
                if (main == s[j] && i + i - j + 1 <= s.lastIndex && s[i + i - j + 1] != main) {
                    result++
                } else {
                    break
                }
            }
        }

        return result
    }
}