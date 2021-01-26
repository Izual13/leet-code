package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.math.sqrt

@Suppress("ClassName")
class `Climbing Stairs` {
    @Test
    fun test1() {
        Assertions.assertEquals(3, climbStairs(3))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(2, climbStairs(2))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(5, climbStairs(4))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(1134903170, climbStairs(44))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(2504730781961, fastClimbStairs(60))
    }

    private fun climbStairs(n: Int): Int {
        if (n <= 3) {
            return n
        }

        var n1 = 2
        var n2 = 3

        for (i in 4..n){
            val tmp = n1+n2
            n1 = n2
            n2 = tmp
        }

        return n2
    }

    private fun fastClimbStairs(n: Int): Long {
        val sqrt5 = sqrt(5.0)
        val fibn = ((1 + sqrt5) / 2).pow((n + 1).toDouble()) - ((1 - sqrt5) / 2).pow((n + 1).toDouble())
        return (fibn / sqrt5).toLong()
    }
}