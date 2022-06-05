package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Best Time to Buy and Sell Stock` {


    @Test
    fun test1() {
        Assertions.assertEquals(5, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    private fun maxProfit(prices: IntArray): Int {
        var minPrise = prices[0]
        var result = 0

        for (i in 1..prices.lastIndex) {
            val price = prices[i]
            if (minPrise > price) {
                minPrise = price
            } else if (price - minPrise > result) {
                result = price - minPrise
            }
        }

        return result
    }
}