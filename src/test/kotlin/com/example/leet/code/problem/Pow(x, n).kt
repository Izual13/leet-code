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


    private fun myPow(x: Double, n: Int): Double {
        if (x == 0.0 || x == 1.0) {
            return x
        } else if (n == 0) {
            return 1.0
        }

        var m = x

        var count: Long = n.toLong()

        if (n < 0) {
            count = -n.toLong()
            m = 1 / x
        }

        var result = 1.0
        val cache = DoubleArray(32)
        cache[0] = m
        while (0L != count) {
            for (i in 31 downTo 0) {
                val shl = 1L.shl(i)
                if (shl <= count) {
                    var tmp = m
                    if (cache[i] != 0.0) {
                        tmp = cache[i]
                    } else {
                        for (j in 1..i) {
                            tmp *= tmp
                            cache[j] = tmp
                        }

                    }

                    result *= tmp
                    count -= shl
                }
                if (count == 0L) {
                    return result
                }
            }
        }

        return result
    }

}