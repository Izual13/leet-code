package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Kth Largest Element in an Array` {

    @Test
    fun test1() {
        Assertions.assertEquals(5, findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }


    private fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }

        nums.forEach { queue.add(it) }

        for (i in 1 until k) {
            queue.poll()
        }
        return queue.poll()
    }

}