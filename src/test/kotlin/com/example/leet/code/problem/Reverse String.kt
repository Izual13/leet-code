package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Reverse String` {

    @Test
    fun test1() {
        val s = charArrayOf('h', 'e', 'l', 'l', 'o')
        reverseString(s)

        Assertions.assertArrayEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), s)
    }

    @Test
    fun test2() {
        val s = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
        reverseString(s)

        Assertions.assertArrayEquals(charArrayOf('h', 'a', 'n', 'n', 'a', 'H'), s)
    }


    private fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.lastIndex

        while (start <= end) {
            val tmp = s[start]
            s[start] = s[end]
            s[end] = tmp
            start++
            end--
        }
    }
}