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

    val set = HashSet<Char>(listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'))

    private fun halvesAreAlike(s: String): Boolean {
        val mid = s.length / 2
        var result = 0

        for (i in 0 until mid) {
            if (set.contains(s[i])) result++
            if (set.contains(s[s.lastIndex - i])) result--
        }

        return result == 0
    }
}