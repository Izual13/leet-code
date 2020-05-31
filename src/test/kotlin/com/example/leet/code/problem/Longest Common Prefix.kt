package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Longest Common Prefix` {
    @Test
    fun test1() {
        Assertions.assertEquals(longestCommonPrefix(arrayOf("flower", "flow", "flight")), "fl")
    }

    private fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }

        val smallString = strs.minBy { it.length }!!
        val result = StringBuilder(smallString.length)
        for (index in smallString.indices) {
            for (str in strs) {
                if (str[index] != smallString[index]) {
                    return result.toString()
                }
            }
            result.append(smallString[index])
        }

        return result.toString()
    }
}
