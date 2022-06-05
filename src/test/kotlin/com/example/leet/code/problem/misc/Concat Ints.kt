package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@Suppress("ClassName")
class `Concat Ints` {


    @ParameterizedTest
    @MethodSource("params")
    fun test1(a: Int, b: Int) {
        val concat = concat(a, b)
        Assertions.assertEquals(a, (concat shr 32).toInt())
        Assertions.assertEquals(b, concat.toInt())
    }

    companion object {
        @JvmStatic
        fun params() = listOf(
            Arguments.of(Int.MIN_VALUE, Int.MIN_VALUE),
            Arguments.of(Int.MAX_VALUE, Int.MAX_VALUE),
            Arguments.of(-1, -1),
            Arguments.of(-1000, Int.MAX_VALUE),
            Arguments.of(1000, Int.MAX_VALUE),
            Arguments.of(1000, Int.MIN_VALUE),
            Arguments.of(-1000, Int.MIN_VALUE),
            Arguments.of(Int.MAX_VALUE, -1000),
            Arguments.of(Int.MAX_VALUE, 1000),
            Arguments.of(Int.MIN_VALUE, 1000),
            Arguments.of(Int.MIN_VALUE, -1000),
            Arguments.of(15, 15),
            Arguments.of(666, 666)
        )
    }

    private fun concat(x: Int, y: Int): Long {
        return x.toLong() shl 32 or (y.toLong() and 0xffffffffL)
    }
}