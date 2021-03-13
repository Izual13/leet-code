package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Hamming Distance` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, hammingDistance(1, 4))
    }

    private fun hammingDistance(x: Int, y: Int): Int {
        var n1 = x
        var n2 = y
        var count = 0

        while (n1 != 0 || n2 != 0) {
            println(n1.toString(2))
            println(n2.toString(2))
            if (n1.and(1).xor(n2.and(1)) == 1) {
                count++
            }

            n1 = n1.ushr(1)
            n2 = n2.ushr(1)
        }

        return count
    }
}