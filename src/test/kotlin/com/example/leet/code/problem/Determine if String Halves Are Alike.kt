package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Determine if String Halves Are Alike` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, halvesAreAlike("book"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(true, halvesAreAlike("AbCdEfGh"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(false, halvesAreAlike("MerryChristmas"))
    }

    val set = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    private fun halvesAreAlike(s: String): Boolean {
        val array = s.toCharArray()
        val lastIndex = s.lastIndex
        val mid = s.length / 2
        var result = 0

        for (i in 0 until mid) {
            if (set.contains(array[i])) result++
            if (set.contains(array[lastIndex - i])) result--
        }

        return result == 0
    }
}