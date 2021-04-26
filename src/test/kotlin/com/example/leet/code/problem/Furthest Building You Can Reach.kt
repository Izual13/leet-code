package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Furthest Building You Can Reach` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1))
    }

    //Example 2:
//
//Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
//Output: 7
//
//Example 3:
//
//Input: heights = [14,3,19,3], bricks = 17, ladders = 0
//Output: 3
    @Test
    fun test2() {
        Assertions.assertEquals(7, furthestBuilding(intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19), 10, 2))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, furthestBuilding(intArrayOf(14, 3, 19, 3), 17, 0))
    }


    private fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int, startIndex: Int = 0): Int {
        if (heights.size <= startIndex) {
            return heights.size
        }

        var tmp = startIndex

        for (i in startIndex..heights.lastIndex) {
            if (heights[tmp] < heights[i]) {
                break
            }
            tmp = i
        }

        if (tmp == heights.lastIndex) {
            return tmp
        }

        var brick = tmp
        var ladder = tmp
        val neededBricks = heights[tmp + 1] - heights[tmp]
        if (bricks - neededBricks >= 0) {
            brick = furthestBuilding(heights, bricks - neededBricks, ladders, tmp + 1)
        }

        if (ladders != 0) {
            ladder = furthestBuilding(heights, bricks, ladders - 1, tmp + 1)
        }


        return Math.max(brick, ladder)
    }
}