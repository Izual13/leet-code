package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Happy Number` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isHappy(19))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, isHappy(2))
    }

    val set = HashSet<Int>()

    private fun isHappy(n: Int): Boolean {
        if (n == 1) {
            return true
        }

        if (!set.add(n)) {

            return false
        }

        var result = 0
        var tmp = n
        while (tmp != 0) {
            val x = tmp % 10
            result += x * x
            tmp /= 10
        }

        return isHappy(result)
    }
}