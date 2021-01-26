package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger

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

    private fun climbStairs(n: Int, stepCount: Int = 0, result: AtomicInteger = AtomicInteger()): Int {
        if (n == 0) {
            return 0
        }

        if (n == stepCount) {
            return result.incrementAndGet()
        } else if (stepCount < n) {
            climbStairs(n, stepCount + 1, result)
            climbStairs(n, stepCount + 2, result)
        }

        return result.get()
    }


}