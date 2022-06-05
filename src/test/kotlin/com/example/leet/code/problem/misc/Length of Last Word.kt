package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Length of Last Word` {

    @Test
    fun test1() {
        Assertions.assertEquals(lengthOfLastWord("Hello World"), 5)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(lengthOfLastWord("Hello World 123"), 3)
    }

    @Test
    fun test3() {
        Assertions.assertEquals(lengthOfLastWord("Hello World  "), 5)
    }

    private fun lengthOfLastWord(s: String): Int {
        var length = 0
        var ignoreEmpty = 0

        for (i in s.indices) {
            if (s[i] != ' ') {
                length++
            } else {
                if (length > 0) {
                    ignoreEmpty = length
                }
                length = 0
            }
        }
        return if (length > 0) length else ignoreEmpty
    }
}