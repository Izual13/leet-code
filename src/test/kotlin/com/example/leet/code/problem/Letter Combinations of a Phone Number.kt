package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Letter Combinations of a Phone Number` {

    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), letterCombinations("23"))
    }
    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf("adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"), letterCombinations("234"))
    }

    fun letterCombinations(digits: String, prefix: String = "", result: MutableList<String> = mutableListOf()): List<String> {
        if (digits.length == 0) {
            return result
        }

        val tmp = when (digits[0].toString()) {
            "2" -> arrayListOf("a", "b", "c")
            "3" -> arrayListOf("d", "e", "f")
            "4" -> arrayListOf("g", "h", "i")
            "5" -> arrayListOf("j", "k", "l")
            "6" -> arrayListOf("m", "n", "o")
            "7" -> arrayListOf("p", "q", "r", "s")
            "8" -> arrayListOf("t", "u", "v")
            "9" -> arrayListOf("w", "x", "y", "z")
            else -> arrayListOf()

        }

        if (digits.length == 1) {
            tmp.forEach { result.add("$prefix$it") }
        } else {
            tmp.forEach {
                letterCombinations(digits.substring(1), "$prefix$it", result)
            }
        }

        return result
    }


}