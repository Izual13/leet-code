package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Reverse Bits` {
    @Test
    fun test1() {
        Assertions.assertEquals(964176192, reverseBits(Integer.parseInt("00000010100101000001111010011100", 2)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(Int.MIN_VALUE, reverseBits(1))
    }

    private fun reverseBits(n: Int): Int {
        var result = 0
        for (i in 0..31) {
            val tmp = n.shr(i).and(1)
            result = result.or(tmp.shl(31 - i))
        }

        return result
    }
}
