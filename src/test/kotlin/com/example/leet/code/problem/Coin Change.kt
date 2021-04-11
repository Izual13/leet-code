package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
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
        Assertions.assertEquals(34, coinChange(intArrayOf(1, 2, 3), 100))
    }

    private fun coinChange(coins: IntArray, amount: Int): Int {

        val cache = IntArray(amount + 1) { amount + 1 }
        cache[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (coin <= i) {
                    cache[i] = min(cache[i], 1 + cache[i - coin])
                }
            }
        }

        return if (cache[amount] == amount + 1) -1 else cache[amount]
    }
}