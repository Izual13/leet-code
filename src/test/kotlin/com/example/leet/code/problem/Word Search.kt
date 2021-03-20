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


    private fun exist(board: Array<CharArray>, word: String): Boolean {
        val path = Array(board.size) { BooleanArray(board[0].size) }
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == word[0]) {

                    path[i][j] = true
                    if (exist(board, word, 1, i, j, path)) {
                        return true
                    }
                    path[i][j] = false
                }
            }
        }

        return false
    }

    private fun exist(board: Array<CharArray>, word: String, start: Int, i: Int, j: Int, path: Array<BooleanArray>): Boolean {
        println("${start}")
        for (pp in path) {
            println(pp.contentToString())
        }

        if (start == word.length) {
            return true
        } else if (start > word.length) {
            return false
        }

        //up
        if (i - 1 in board.indices && j in board[0].indices && !path[i - 1][j] && word[start] == board[i - 1][j]) {
            path[i - 1][j] = true
            if (exist(board, word, start + 1, i - 1, j, path)) {
                return true
            }
            path[i - 1][j] = false
        }

        //down
        if (i + 1 in board.indices && j in board[0].indices && !path[i + 1][j] && word[start] == board[i + 1][j]) {
            path[i + 1][j] = true
            if (exist(board, word, start + 1, i + 1, j, path)) {
                return true
            }
            path[i + 1][j] = false
        }

        //left
        if (i in board.indices && j - 1 in board[0].indices && !path[i][j - 1] && word[start] == board[i][j - 1]) {
            path[i][j - 1] = true
            if (exist(board, word, start + 1, i, j - 1, path)) {
                return true
            }
            path[i][j - 1] = false
        }

        //right
        if (i in board.indices && j + 1 in board[0].indices && !path[i][j + 1] && word[start] == board[i][j + 1]) {
            path[i][j + 1] = true
            if (exist(board, word, start + 1, i, j + 1, path)) {
                return true
            }
            path[i][j + 1] = false
        }

        return false
    }
}