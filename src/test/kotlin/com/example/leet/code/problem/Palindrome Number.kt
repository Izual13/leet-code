package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Palindrome Number` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isPalindrome(121))
    }


    private fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        } else if (x < 10) {
            return true
        }

        val list = ArrayList<Byte>(10)

        var reminder = x
        while (reminder != 0) {
            list.add((reminder % 10).toByte())
            reminder /= 10
        }

        for (i in 0..list.size / 2) {
            if (list[i] != list[list.size - i - 1]) {
                return false
            }
        }

        return true
    }
}