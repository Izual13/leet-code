package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `String to Integer (atoi)` {

    @Test
    fun test1() {
        Assertions.assertEquals(myAtoi("    ___-42"), -42)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(myAtoi("4193 with words"), 4193)
    }

    fun myAtoi(s: String): Int {
        var result = 0L
        var negative = false

        val chars = s.toCharArray()
        val length = chars.size
        var index = 0

        while (index < length && (chars[index] == ' ' || chars[index] == '_')) {
            index++
        }

        if (index < length && chars[index] == '-') {
            negative = true
            index++
        } else if (index < length && chars[index] == '+') {
            index++
        }

        while (index < length && (chars[index] in '0'..'9')) {

            var tmp = result * 10
            val number = chars[index] - '0'

            if (negative) {
                tmp -= number
            } else {
                tmp += number
            }

            index++

            if (tmp > Int.MAX_VALUE) {
                return Int.MAX_VALUE
            } else if (tmp < Int.MIN_VALUE) {
                return Int.MIN_VALUE
            }
            result = tmp
        }

        return result.toInt()
    }
}