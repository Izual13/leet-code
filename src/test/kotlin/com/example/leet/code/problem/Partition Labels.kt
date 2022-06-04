package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Partition Labels` {

    @Test
    fun test1() {
        Assertions.assertEquals(listOf(9, 7, 8), partitionLabels("ababcbacadefegdehijhklij"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(listOf(10), partitionLabels("eccbbbbdec"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(listOf(9, 1), partitionLabels("eaaaabaaec"))
    }


    private fun partitionLabels(s: String): List<Int> {
        val result = ArrayList<Int>()
        val chars = s.toCharArray()

        var tmp = 0
        var lastValue = -1
        for (i in chars.indices) {
            val c = chars[i]
            for (j in i + 1..chars.lastIndex) {
                if (c == chars[j] && tmp < j) {
                    tmp = j
                }
            }

            if (tmp == i) {
                result.add(tmp - lastValue)
                lastValue = i
                tmp = i + 1
            }
        }

        return result
    }
}