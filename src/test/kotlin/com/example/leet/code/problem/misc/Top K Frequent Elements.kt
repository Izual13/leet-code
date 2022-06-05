package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Top K Frequent Elements` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(1, 2), topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2))
    }

    @Test
    fun test2() {
        Assertions.assertArrayEquals(intArrayOf(1), topKFrequent(intArrayOf(1), 1))
    }


    private fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = HashMap<Int, Int>()

        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        val heap = PriorityQueue<Int> { n1, n2 -> map[n2]!!.compareTo(map[n1]!!)}

        map.keys.forEach { heap.add(it) }

        val result = IntArray(k)

        for (i in 0 until k) {
            result[i] = heap.poll()
        }
        return result
    }
}