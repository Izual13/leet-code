package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Number of Islands` {

    @Test
    fun test1() {

        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'), charArrayOf('1', '1', '0', '1', '0'), charArrayOf('1', '1', '0', '0', '0'), charArrayOf('0', '0', '0', '0', '0')
        );

        Assertions.assertEquals(1, numIslands(grid))
    }

    @Test
    fun test2() {

        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        );

        Assertions.assertEquals(3, numIslands(grid))
    }

    @Test
    fun test3() {

        val grid = arrayOf(
            charArrayOf('1', '1', '1'),
            charArrayOf('0', '1', '0'),
            charArrayOf('1', '1', '1'),
        );

        Assertions.assertEquals(1, numIslands(grid))
    }


    private fun numIslands(grid: Array<CharArray>): Int {
        val height = grid.size
        val width = grid[0].size
        val allIslands = height * width
        val findUnion = FindUnion(allIslands)


        for (y in grid.indices) {
            for (x in grid[0].indices) {
                if (grid[y][x] != '1') {
                    findUnion.close(width * y + x)
                    println(findUnion.toString())
                    continue
                }

                if (y == 0 && x == 0) {
                    continue
                }

                if (y > 0 && grid[y - 1][x] == '1') {
                    findUnion.connected(width * (y - 1) + x, width * y + x)
                }

                if (x > 0 && grid[y][x - 1] == '1') {
                    findUnion.connected(width * y + x - 1, width * y + x)
                }

                println(findUnion.toString())
            }
        }

        return findUnion.count
    }


    class FindUnion(n: Int) {
        private val findUnion = IntArray(n) { it }
        var count = n

        private fun find(id: Int): Int {
            var root = id
            while (findUnion[root] != root) {
                root = findUnion[root]
            }
            return root
        }

        fun connected(id1: Int, id2: Int) {
            val root1 = find(id1)
            val root2 = find(id2)
            if (root1 == root2) {
                return
            }

            var tmp = id2
            while (findUnion[tmp] != root1) {
                tmp = findUnion[tmp]
                findUnion[tmp] = root1
            }
            count--
        }

        fun close(id: Int) {
            if (findUnion[id] != -1) {
                findUnion[id] = -1
                count--
            }
        }

        override fun toString(): String {
            return "FindUnion(findUnion=${findUnion.contentToString()})"
        }
    }
}