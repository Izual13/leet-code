package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Isomorphic Strings` {


    @Test
    fun test1() {
        println('0'.toInt())
        println('9'.toInt())
        println('z'.toInt())
        println('0'.toInt() - ('0'.toInt() - 1))

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
            if (sArray[a.toInt()] == 0 && tArray[b.toInt()] == 0) {
                sArray[a.toInt()] = b.toInt()
                tArray[b.toInt()] = a.toInt()
            } else if (sArray[a.toInt()] != b.toInt() || tArray[b.toInt()] != a.toInt()) {
                return false
            }
        }
        return true
    }
}