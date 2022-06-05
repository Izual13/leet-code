package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Partition Labels` {

    @Test
    fun test1() {
        Assertions.assertEquals(listOf(9, 7, 8), partitionLabels("ababcbacadefegdehijhklij"))
        Assertions.assertEquals(listOf(9, 7, 8), partitionLabels2("ababcbacadefegdehijhklij"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(listOf(10), partitionLabels("eccbbbbdec"))
        Assertions.assertEquals(listOf(10), partitionLabels2("eccbbbbdec"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(listOf(9, 1), partitionLabels("eaaaabaaec"))
        Assertions.assertEquals(listOf(9, 1), partitionLabels2("eaaaabaaec"))
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

    private fun partitionLabels2(s: String): List<Int> {
        val result = ArrayList<Int>()
        val map = IntArray(26)
        val chars = s.toCharArray()

        for (i in chars.indices) {
            map[chars[i].code - 'a'.code] = i
        }


        var tmp = 0
        var lastValue = -1
        for (i in chars.indices) {
            val c = chars[i]
            tmp = max(tmp, map[c.code - 'a'.code])

            if (tmp == i) {
                result.add(tmp - lastValue)
                lastValue = i
                tmp = i + 1
            }
        }

        return result
    }
}