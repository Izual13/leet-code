package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.collections.HashMap

@Suppress("ClassName")
class `Target Sum` {


    @Test
    fun test1() {
        Assertions.assertEquals(5, findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
    }


    private fun findTargetSumWays(nums: IntArray, target: Int, current: Int = 0, index: Int = 0, cache: HashMap<Pair<Int, Int>, Int> = HashMap()): Int {
        if (index > nums.lastIndex) {
            return if (target == current) 1 else 0
        } else if (cache.contains(index to current)) {
            return cache[index to current]!!
        }

        var result = 0
        result += findTargetSumWays(nums, target, current + nums[index], index + 1, cache)
        result += findTargetSumWays(nums, target, current - nums[index], index + 1, cache)

        cache[index to current] = result

        return result
    }

}