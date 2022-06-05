package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Shuffle an Array` {
    @Test
    fun test1() {
        val solution = Solution(intArrayOf(1, 2, 3, 4, 5))
        for (i in 0..10){
            Assertions.assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), solution.reset())
            solution.shuffle()
        }
    }


    class Solution(val nums: IntArray) {

        private var copy = nums.clone()
        private var random = Random()

        fun reset(): IntArray {
            return nums
        }

        fun shuffle(): IntArray {
            val a = random.nextInt(nums.size)
            val b = random.nextInt(nums.size)

            val tmp = copy[a]
            copy[a] = copy[b]
            copy[b] = tmp
            return copy
        }

    }
}