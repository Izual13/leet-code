package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Palindrome Partitioning` {

    @Test
    fun test1() {
        Assertions.assertEquals(listOf(listOf("a", "a", "b"), listOf("aa", "b")), partition("aab"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(listOf(listOf("a")), partition("a"))
    }


    private fun partition(rest: String, prefix: List<String> = listOf(), result: MutableList<List<String>> = mutableListOf()): List<List<String>> {

        if(rest.isEmpty()){
            result.add(prefix)
        }

        var tmp = ""
        for (i in rest.indices) {
            tmp += rest[i]
            if (isPalindrom(tmp)) {
                partition(rest.substring(i+1), prefix + tmp, result)
            }
        }

        return result
    }

    private fun isPalindrom(s: String): Boolean {
        var start = 0
        var end = s.length - 1

        while (start < end) {
            if (s[start++] != s[end--]) {
                return false
            }
        }

        return true
    }
}