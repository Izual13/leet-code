package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Best Time to Buy and Sell Stock II` {


    @Test
    fun test1() {
        Assertions.assertEquals(7, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    private fun maxProfit(prices: IntArray): Int {
        var maxprofit = 0
        for (i in 1..prices.lastIndex) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1]
            }
        }
        return maxprofit
    }
}