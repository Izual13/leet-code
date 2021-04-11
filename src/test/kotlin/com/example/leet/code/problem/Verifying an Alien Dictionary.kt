package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

@Suppress("ClassName")
class `Verifying an Alien Dictionary` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isAlienSorted(arrayOf("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, isAlienSorted(arrayOf("word", "world", "row"), "worldabcefghijkmnpqstuvxyz"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(false, isAlienSorted(arrayOf("apple","app"), "abcdefghijklmnopqrstuvwxyz"))
    }

    private fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val map = order.mapIndexed { index, c -> c to index }.toMap()

        var first = words[0]
        for (i in 1..words.lastIndex) {
            if (!check(first, words[i], map)) {
                return false
            }
            first = words[i]
        }
        return true
    }


    private fun check(s1: String, s2: String, map: Map<Char, Int>): Boolean {
        val l1 = s1.lastIndex
        val l2 = s2.lastIndex

        for (i in 0..min(l1, l2)) {
            val i1 = map[s1[i]]!!
            val i2 = map[s2[i]]!!
            if (i1 > i2) {
                return false
            } else if (i1 < i2) {
                return true
            }
        }

        if (l1 > l2) {
            return false
        }

        return true
    }
}