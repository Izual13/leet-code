package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Subrectangle Queries` {


    @Test
    fun test1() {
        val subrectangleQueries = SubrectangleQueries(arrayOf(intArrayOf(1, 2, 1), intArrayOf(4, 3, 4), intArrayOf(3, 2, 1), intArrayOf(1, 1, 1)))


        Assertions.assertEquals(1, subrectangleQueries.getValue(0, 2))
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);


        Assertions.assertEquals(5, subrectangleQueries.getValue(0, 2))
        Assertions.assertEquals(5, subrectangleQueries.getValue(3, 1))
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);


        Assertions.assertEquals(10, subrectangleQueries.getValue(3, 1))
        Assertions.assertEquals(5, subrectangleQueries.getValue(0, 2))

    }


    class SubrectangleQueries(val rectangle: Array<IntArray>) {

        fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
            for (i in row1..row2) {
                for (j in col1..col2) {
                    rectangle[i][j] = newValue
                }
            }
        }

        fun getValue(row: Int, col: Int): Int {
            return rectangle[row][col]
        }

    }
}