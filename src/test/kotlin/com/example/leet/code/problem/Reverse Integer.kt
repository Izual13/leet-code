package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Reverse Integer` {
    @Test
    fun test1() {
        Assertions.assertEquals(reverse(-123), -321)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(reverse(1534236469), 0)
    }

    private fun reverse(x: Int): Int {
        var tmp = x
        var result = 0L
        while (tmp != 0) {
            result = result * 10 + (tmp % 10)
            tmp /= 10
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0
        }
        return result.toInt()
    }
}