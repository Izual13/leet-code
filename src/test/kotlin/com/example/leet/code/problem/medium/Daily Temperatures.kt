package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList

@Suppress("ClassName")
class `Daily Temperatures` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0), dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)))
        Assertions.assertArrayEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0), dailyTemperatures2(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)))
    }


    private fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)

        for (i in temperatures.indices) {
            val c = temperatures[i]
            var tmp = 0
            for (j in i + 1..temperatures.lastIndex) {
                if (c < temperatures[j]) {
                    tmp = j - i
                    break
                }
            }

            result[i] = tmp
        }


        return result
    }

    private fun dailyTemperatures2(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = LinkedList<Pair<Int, Int>>()

        stack.push(0 to temperatures[0])
        for (i in 1..temperatures.lastIndex) {
            val c = temperatures[i]

            while (stack.peek() != null && stack.peek().second < c) {
                val pair = stack.pop()
                result[pair.first] = i - pair.first
            }

            stack.push(i to temperatures[i])
        }

        return result
    }
}