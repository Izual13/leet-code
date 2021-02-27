package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger


@Suppress("ClassName")
class `Unique Paths` {

    @Test
    fun test1() {
        Assertions.assertEquals(28, uniquePaths(3, 7))
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun test2() {
        Assertions.assertEquals(1916797311, uniquePaths(51, 9))
    }


    private fun uniquePaths(m: Int, n: Int, i: Int = 0, j: Int = 0, count: AtomicInteger = AtomicInteger()): Int {
        if (i == m - 1 && j == n - 1) {
            count.incrementAndGet()
        }

        if (i != m - 1) {
            uniquePaths(m, n, i + 1, j, count)
        }

        if (j != n - 1) {
            uniquePaths(m, n, i, j + 1, count)
        }

        return count.get()
    }
}