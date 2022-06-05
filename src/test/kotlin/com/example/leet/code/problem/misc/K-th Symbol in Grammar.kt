package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.pow


@Suppress("ClassName")
class `K-th Symbol in Grammar` {

    @Test
    fun test1() {
        Assertions.assertEquals(1, kthGrammar(4, 5))
    }


    private fun kthGrammar(N: Int, K: Int): Int {
        if (N == 1 && K == 1)
            return 0

        val mid = (2.0.pow(N.toDouble() - 1)).toInt() / 2

        return when {
            K <= mid -> kthGrammar(N - 1, K)
            kthGrammar(N - 1, K - mid) == 0 -> 1
            else -> 0
        }

    }
}