package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Valid Sudoku` {

    @Test
    fun test1() {
        val board = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )


        Assertions.assertEquals(true, isValidSudoku(board))
    }

    @Test
    fun test2() {
        val board = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        Assertions.assertEquals(false, isValidSudoku(board))
    }

    @Test
    fun test3() {
        val board = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('.', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        Assertions.assertEquals(false, isValidSudoku(board))
    }

    private fun isValidSudoku(board: Array<CharArray>): Boolean {
        val map = HashMap<String, HashSet<Char>>()

        for (i in board.indices) {
            for (j in board[i].indices) {
                val element = board[i][j]
                if (element == '.') {
                    continue
                }

                var set = map.computeIfAbsent("r$i") { HashSet() }
                if (!set.add(element)) {
                    return false
                }
                set = map.computeIfAbsent("c$j") { HashSet() }
                if (!set.add(element)) {
                    return false
                }

                set = map.computeIfAbsent("m${i / 3}${j / 3}") { HashSet() }
                if (!set.add(element)) {
                    return false
                }
            }
        }
        return true
    }
}
