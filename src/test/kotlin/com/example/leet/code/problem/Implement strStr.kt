package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Implement strStr` {

    @Test
    fun test1() {
        Assertions.assertEquals(strStr("hello", "ll"), 2)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(strStr("aaaaa", "bba"), -1)
    }


    private fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }

        return haystack.indexOf(needle)
    }
}