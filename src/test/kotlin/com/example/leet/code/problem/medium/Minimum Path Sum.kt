package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList
import kotlin.math.min

@Suppress("ClassName")
class `Minimum Path Sum` {

    @Test
    fun test1() {
        Assertions.assertEquals(7, minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(12, minPathSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(0, minPathSum(arrayOf(intArrayOf(0))))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(6, minPathSum(arrayOf(intArrayOf(1, 2, 3))))
    }

    private fun minPathSum(grid: Array<IntArray>): Int {

        val q: LinkedList<Pair<Int, Int>> = LinkedList()

        val cache: Array<IntArray> = Array(grid.size) { IntArray(grid[0].size) }

        if (grid.lastIndex > 0) {
            q.push(0 to 1)
        }

        if (grid[0].lastIndex > 0) {
            q.push(1 to 0)
        }

        cache[0][0] = grid[0][0]

        while (q.isNotEmpty()) {
            val (x, y) = q.removeLast()

            if (cache[y][x] != 0) {
                continue
            }

            val c = grid[y][x]
            if (x == 0) {
                cache[y][x] = cache[y - 1][x] + c
            } else if (y == 0) {
                cache[y][x] = cache[y][x - 1] + c
            } else {
                cache[y][x] = min(cache[y - 1][x] + c, cache[y][x - 1] + c)
            }

            if (y == grid.lastIndex && x == grid[0].lastIndex) {
                return cache[grid.lastIndex][grid[0].lastIndex]
            } else if (y == grid.lastIndex) {
                q.push(x + 1 to 0)
            } else if (x == grid[0].lastIndex) {
                q.push(x to y + 1)
            } else {
                q.push(x + 1 to y)
                q.push(x to y + 1)
            }
        }
        return cache[grid.lastIndex][grid[0].lastIndex]
    }
}