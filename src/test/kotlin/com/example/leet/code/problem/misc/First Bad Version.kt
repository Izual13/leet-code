package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `First Bad Version` {

    @Test
    fun test1() {
        Assertions.assertEquals(
            4, firstBadVersion(5)
        )
    }


    private fun isBadVersion(version: Int): Boolean {
        return when (version) {
            0 -> false
            1 -> false
            2 -> false
            3 -> false
            else -> true
        }
    }

    private fun firstBadVersion(n: Int): Int {
        var result = -1
        var start = 0
        var end = n


        while (start <= end) {
            val mid = start + (end - start) / 2

            if (isBadVersion(mid)) {
                result = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return result
    }
}