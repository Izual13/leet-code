package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Valid Anagram` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isAnagram("anagram", "nagaram"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, isAnagram("rat", "car"))
    }


    private fun isAnagram(s: String, t: String): Boolean {
        val map = HashMap<Char, Int>()
        for (c in s) {
            val count = map.computeIfAbsent(c) { 0 }
            map[c] = count + 1
        }

        for (c in t) {
            val count = map.computeIfAbsent(c) { 0 }
            map[c] = count - 1

            if (count == 0) {
                return false
            }
        }

        for (c in map.values) {
            if (c != 0) {
                return false
            }
        }

        return true
    }
}