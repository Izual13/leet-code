package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Count Primes` {
    @Test
    fun test1() {
        Assertions.assertEquals(4, countPrimes(10))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(0, countPrimes(0))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(0, countPrimes(1))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(8, countPrimes(20))
    }

    private fun countPrimes(n: Int): Int {
        if (n <= 1) {
            return 0
        }


        val array = BooleanArray(n)
        array[0]=true
        array[1]=true

        for (i in 2 until n) {
            if (array[i]) {
                continue
            }

            for (j in i+i until n step i){
                if (array[j]) {
                    continue
                }

                array[j] = true
            }
        }

        return array.count { !it }
    }
}