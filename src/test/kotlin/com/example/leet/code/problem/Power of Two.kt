package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Power of Two` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isPowerOfTwo(1))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(true, isPowerOfTwo(2))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(false, isPowerOfTwo(3))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(true, isPowerOfTwo(4))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(true, isPowerOfTwo(16))
    }

    @Test
    fun test6() {
        Assertions.assertEquals(false, isPowerOfTwo(5))
    }

    @Test
    fun test7() {
        Assertions.assertEquals(false, isPowerOfTwo(0))
    }

    @Test
    fun test8() {
        Assertions.assertEquals(false, isPowerOfTwo(-2))
    }


    private fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && n.and(n - 1) == 0
    }
}