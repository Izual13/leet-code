package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Count and Say` {

    @Test
    fun test1() {
        Assertions.assertEquals("1211", countAndSay(4))
    }

    @Test
    fun test2() {
        Assertions.assertEquals("312211", countAndSay(6))
    }


    private fun countAndSay(n: Int): String {
        var result = "1"
        for (i in 1 until n) {
            val s = StringBuilder()
            var tmp = result[0]
            var count = 1

            for (j in 1..result.length) {
                when {
                    j == result.length -> {
                        s.append(count).append(tmp)
                    }
                    tmp == result[j] -> {
                        count++
                    }
                    else -> {
                        s.append(count).append(tmp)
                        tmp = result[j]
                        count = 1
                    }
                }
            }
            result = s.toString()
        }

        return result
    }
}