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

        val a = (0 until mid).map { s[it] }.filter(set::contains).count()
        val b = (mid until s.length).map { s[it] }.filter(set::contains).count()

        return a == b
    }
}