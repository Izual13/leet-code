package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Valid Palindrome` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, isPalindrome("race a car"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(false, isPalindrome("0P"))
    }

    private fun isPalindrome(s: String): Boolean {
        val lowerCase = s.lowercase()
        var start = 0
        var end = s.lastIndex

        while (start < end) {
            if (lowerCase[start] !in 'a'..'z' && lowerCase[start] !in '0'..'9') {
                start++
                continue
            }
            if (lowerCase[end] !in 'a'..'z' && lowerCase[end] !in '0'..'9') {
                end--
                continue
            }

            if (lowerCase[start] == lowerCase[end]) {
                start++
                end--
            } else {
                return false
            }
        }

        return true
    }
}