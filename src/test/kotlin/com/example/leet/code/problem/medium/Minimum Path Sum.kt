package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

@Suppress("ClassName")
class `Minimum Path Sum` {

    @Test
    fun test1() {
        Assertions.assertEquals(7, minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(12, minPathSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4,5,6))))
    }


    private fun minPathSum(grid: Array<IntArray>, x: Int = 0, y: Int = 0, result: Int = 0): Int {
        val newResult = result + grid[y][x]
        if (x == grid[0].lastIndex && y == grid.lastIndex) {
            return newResult
        }

        if (x == grid[0].lastIndex) {
            return minPathSum(grid, x, y + 1, newResult)
        }

        if (y == grid.lastIndex) {
            return minPathSum(grid, x + 1, y, newResult)
        }


        val r1 = minPathSum(grid, x + 1, y, newResult)
        val r2 = minPathSum(grid, x, y + 1, newResult)

        return min(r1, r2)
    }
}