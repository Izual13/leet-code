package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Isomorphic Strings` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isIsomorphic("paper", "title"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, isIsomorphic("foo", "bar"))
    }

    private fun isIsomorphic(s: String, t: String): Boolean {
        val sArray = IntArray(255)
        val tArray = IntArray(255)
        for (i in s.indices) {
            val a = s[i]
            val b = t[i]
            if (sArray[a.code] == 0 && tArray[b.code] == 0) {
                sArray[a.code] = b.code
                tArray[b.code] = a.code
            } else if (sArray[a.code] != b.code || tArray[b.code] != a.code) {
                return false
            }
        }
        return true
    }
}