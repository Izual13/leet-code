package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Multiply Strings` {

    @Test
    fun test1() {
        Assertions.assertEquals("56088", multiply("123", "456"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals("990009", multiply("991", "999"))
    }


    private fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }

        val result = StringBuilder("0".repeat(num1.length + num2.length))

        for (i in num1.lastIndex downTo 0) {
            for (j in num2.lastIndex downTo 0) {
                val x: Int = num1[i] - '0'
                val y: Int = num2[j] - '0'
                val tmp = result[i + j + 1] - '0'
                val z = x * y + tmp

                result.setCharAt(i + j + 1, (z % 10 + '0'.toInt()).toChar())

                val oldValue = result[i + j] - '0'
                result.setCharAt(i + j, (z / 10 + oldValue + '0'.toInt()).toChar())
            }
        }


        return result.toString().replace(Regex("^0+"), "")
    }
}
