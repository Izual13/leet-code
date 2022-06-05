package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs

@Suppress("ClassName")
class `Divide Two Integers` {
    @Test
    fun test1() {
        Assertions.assertEquals(-2, divide(7, -3))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(Int.MAX_VALUE, divide(Int.MIN_VALUE, -1))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, divide(10, 3))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(-1073741824, divide(Int.MIN_VALUE, 2))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(715827882, divide(-2147483648, -3))
    }

    private fun divide(dividend: Int, divisor: Int): Int {
        val sign = (dividend < 0).xor(divisor < 0)
        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        var remainder = abs(dividend.toLong())
        val y = abs(divisor.toLong())


        var result = 0L

        for (i in 31 downTo 0) {
            val shl = y.shl(i)
            if (shl in 1..remainder) {
                remainder -= shl
                result = result.or(1L.shl(i))
            }
        }

        return if (sign) -result.toInt() else result.toInt()
    }




}