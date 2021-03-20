package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Word Search` {


    @Test
    fun test1() {
        val board = arrayOf(charArrayOf('A', 'B', 'C', 'E'), charArrayOf('S', 'F', 'C', 'S'), charArrayOf('A', 'D', 'E', 'E'))
        Assertions.assertEquals(true, exist(board, "ABCCED"))
    }

    @Test
    fun test2() {
        val board = arrayOf(charArrayOf('A', 'B', 'C', 'E'), charArrayOf('S', 'F', 'C', 'S'), charArrayOf('A', 'D', 'E', 'E'))
        Assertions.assertEquals(false, exist(board, "ABCB"))
    }

    @Test
    fun test3() {
        val board = arrayOf(charArrayOf('A', 'B', 'C', 'E'), charArrayOf('S', 'F', 'C', 'S'), charArrayOf('A', 'D', 'E', 'E'))
        Assertions.assertEquals(true, exist(board, "SEE"))
    }


    private fun exist(board: Array<CharArray>, word: String): Boolean {
        val path = Array(board.size) { BooleanArray(board[0].size) }
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (exist(board, word, 0, i, j, path)) {
                    return true
                }
            }
        }

        return false
    }

    private fun exist(board: Array<CharArray>, word: String, start: Int, i: Int, j: Int, path: Array<BooleanArray>): Boolean {
        if (start == word.length) {
            return true
        } else if (start > word.length) {
            return false
        } else if (i !in board.indices || j !in board[0].indices || path[i][j]) {
            return false
        } else if (board[i][j] != word[start]) {
            return false
        }

        path[i][j] = true

        val result = exist(board, word, start + 1, i - 1, j, path) ||
                exist(board, word, start + 1, i + 1, j, path) ||
                exist(board, word, start + 1, i, j - 1, path) ||
                exist(board, word, start + 1, i, j + 1, path)

        path[i][j] = false

        return result
    }
}