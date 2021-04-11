package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.min

@Suppress("ClassName")
class `Coin Change` {

    @Test
    fun test1() {
        Assertions.assertEquals(3, coinChange(intArrayOf(1, 2, 5), 11))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(-1, coinChange(intArrayOf(2), 3))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(0, coinChange(intArrayOf(1), 0))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(2, coinChange(intArrayOf(1, 2147483647), 2))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(2, coinChange(intArrayOf(1, 2, 3), 100))
    }

    private fun coinChange(coins: IntArray, amount: Int, tmp: Int = 0, count: Int = 0, result: AtomicInteger = AtomicInteger(Int.MAX_VALUE)): Int {
        if (tmp == amount) {
            val tmpResult = result.get()
            result.set(min(tmpResult, count))
            return result.get()
        } else if (tmp > amount || tmp < 0) {
            return -1
        }

        for (i in coins) {
            coinChange(coins, amount, tmp + i, count + 1, result)
        }

        return if (result.get() == Int.MAX_VALUE) -1 else result.get()
    }
}