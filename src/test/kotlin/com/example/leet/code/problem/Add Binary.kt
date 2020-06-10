package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Add Binary` {


    @Test
    fun test1() {
        Assertions.assertEquals("10101", addBinary("1010", "1011"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals("100", addBinary("11", "1"))
    }

    private fun addBinary(a: String, b: String): String {

        val result = StringBuffer(Integer.max(a.length, b.length))
        var i = a.length - 1
        var j = b.length - 1

        var tmp = false
        while (i >= 0 && j >= 0) {
            val x = a[i] == '1'
            val y = b[j] == '1'

            if (x && y && tmp) {
                result.append("1")
            } else if ((x && y) || (x && tmp) || (y && tmp)) {
                result.append("0")
                tmp = true
            } else if (x || y || tmp) {
                result.append("1")
                tmp = false
            } else {
                result.append(0)
            }

            i--
            j--
        }

        while (i >= 0) {
            val x = a[i--] == '1'

            if (x && tmp) {
                result.append("0")
            } else if (x || tmp) {
                result.append("1")
                tmp = false
            } else {
                result.append("0")
            }
        }

        while (j >= 0) {
            val x = b[j--] == '1'

            if (x && tmp) {
                result.append("0")
            } else if (x || tmp) {
                result.append("1")
                tmp = false
            } else {
                result.append("0")
            }
        }

        if (tmp) {
            result.append("1")
        }


        return result.reverse().toString()
    }
}