package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max


@Suppress("ClassName")
class `Richest Customer Wealth` {

    @Test
    fun test1() {
        Assertions.assertEquals(17, maximumWealth2(arrayOf(intArrayOf(2, 8, 7), intArrayOf(7, 1, 3), intArrayOf(1, 9, 5))))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(17, maximumWealth(arrayOf(intArrayOf(2, 8, 7), intArrayOf(7, 1, 3), intArrayOf(1, 9, 5))))
    }

    private fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.maxOf { it.sum() }
    }


    //if kotlin < 1.4
    private fun maximumWealth2(accounts: Array<IntArray>): Int {
        var result = 0

        for (account in accounts) {
            result = max(result, account.sum())
        }

        return result
    }

}