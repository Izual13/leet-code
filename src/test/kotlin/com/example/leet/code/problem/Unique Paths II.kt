package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger


@Suppress("ClassName")
class `Unique Paths II` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, uniquePathsWithObstacles(arrayOf(intArrayOf(0, 1), intArrayOf(0, 0))))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(0, uniquePathsWithObstacles(arrayOf(intArrayOf(1))))
    }

//    @Test
//    @Timeout(5)
//    fun test2() {
//        Assertions.assertEquals(1916797311, uniquePaths(51, 9))
//    }

    private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>, i: Int = 0, j: Int = 0, count: AtomicInteger = AtomicInteger()): Int {

        if (obstacleGrid[i][j] == 1) {
            return count.get()
        }

        if (obstacleGrid.size - 1 == i && obstacleGrid[i].size - 1 == j) {
            count.incrementAndGet()
        }
        if (obstacleGrid.size - 1 != i) {
            uniquePathsWithObstacles(obstacleGrid, i + 1, j, count)
        }

        if (obstacleGrid[0].size - 1 != j) {
            uniquePathsWithObstacles(obstacleGrid, i, j + 1, count)
        }

        return count.get()
    }
}