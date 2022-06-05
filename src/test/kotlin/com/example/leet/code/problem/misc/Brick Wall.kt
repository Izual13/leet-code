package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Brick Wall` {


    @Test
    fun test1() {
        Assertions.assertEquals(
            2, leastBricks(
                arrayListOf(
                    arrayListOf(1, 2, 2, 1), arrayListOf(3, 1, 2), arrayListOf(1, 3, 2),
                    arrayListOf(2, 4), arrayListOf(3, 1, 2), arrayListOf(1, 3, 1, 1)
                )
            )
        )
    }

    @Test
    fun test2() {
        Assertions.assertEquals(
            3, leastBricks(
                arrayListOf(
                    arrayListOf(1), arrayListOf(1), arrayListOf(1)
                )
            )
        )
    }

    private fun leastBricks(wall: List<List<Int>>): Int {
        val cache = HashMap<Int, Int>()
        var leastBricks = 0

        for (row in wall) {
            var count = 0
            for (i in 0 until row.lastIndex) {
                count += row[i]
                cache[count] = cache.getOrDefault(count, 0) + 1
                leastBricks = max(leastBricks, cache[count]!!)
            }
        }

        return wall.size - leastBricks
    }

}