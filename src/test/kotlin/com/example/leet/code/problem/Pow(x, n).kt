package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Pow(x, n)` {

    @Test
    fun test1() {
        Assertions.assertEquals(0.0, myPow(0.0, 0))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1 / 4.0, myPow(2.0, -2))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(81.0, myPow(3.0, 4))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(4.0, myPow(2.0, 2))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(1.0, myPow(1.0, 2147483647))
    }

    @Test
    fun test6() {
        Assertions.assertEquals(0.0, myPow(2.00000, -2147483648))
    }

    @Test
    fun test7() {
        Assertions.assertEquals(0.0000254, myPow(34.00515, -3), 0.000001)
    }

    @Test
    fun test8() {
        Assertions.assertEquals(64.0, myPow(2.0, 6))
    }

    @Test
    fun test9() {
        Assertions.assertEquals(1.0, myPow(2.0, 0))
    }


    private fun myPow(x: Double, n: Int): Double {
        if (x == 0.0 && n == 0) {
            return 0.0
        } else if (x == 1.0 || n == 0) {
            return 1.0
        } else if (x == -1.0) {
            return if (n % 2 == 0) 1.0 else -1.0
        } else if (n == Integer.MIN_VALUE) {
            return 0.0
        } else if (n < 0) {
            return myPow(1 / x, -n)
        }

        var result = 1.0
        var count = n
        var tmp = x

        while (count > 0) {
            if (count % 2 == 1) {
                result *= tmp
            }
            tmp *= tmp
            count = count.shr(1)
        }

        return result
    }

}