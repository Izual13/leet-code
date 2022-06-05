package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Furthest Building You Can Reach` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(7, furthestBuilding(intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19), 10, 2))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, furthestBuilding(intArrayOf(14, 3, 19, 3), 17, 0))
    }


    private fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        if (heights.size <= 1) {
            return heights.size
        }

        val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
        var tmpBricks = bricks
        var tmpLadders = ladders

        for (i in 1..heights.lastIndex) {
            if (heights[i] > heights[i - 1]) {
                val neededBricks = heights[i] - heights[i - 1]
                if (tmpBricks - neededBricks >= 0) {
                    priorityQueue.add(neededBricks)
                    tmpBricks -= neededBricks
                } else if (tmpLadders != 0) {
                    tmpLadders--

                    tmpBricks -= neededBricks
                    priorityQueue.add(neededBricks)
                    tmpBricks += priorityQueue.poll()

                    if (tmpBricks < 0) {
                        return i - 1
                    }

                } else {
                    return i - 1
                }
            }
        }


        return heights.lastIndex
    }
}