package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.StringBuilder

@Suppress("ClassName")
class `Decode String` {

    @Test
    fun test1() {
        Assertions.assertEquals("accaccacc", decodeString("3[a2[c]]"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals("aaaaaaaaaa", decodeString("10[a]"))
    }

    private fun decodeString(s: String): String {
        val result = StringBuilder()

        var start = 0
        while (start <= s.lastIndex) {
            val c = s[start]
            if (c.isDigit()) {
                var endDigit = start + 1
                while (s[endDigit].isDigit()) {
                    endDigit++
                }

                val n = Integer.decode(s.substring(start, endDigit))

                start = endDigit + 1

                var left = 1
                var right = 0
                var cur = start
                while (left != right) {
                    if (s[cur] == ']') {
                        right++
                    } else if (s[cur] == '[') {
                        left++
                    }
                    cur++
                }

                val decodeSubString = decodeString(s.substring(start, cur - 1))

                for (j in 0 until n) {
                    result.append(decodeSubString)
                }
                start = cur
            } else {
                result.append(c)
                start++
            }
        }

        return result.toString()
    }
}