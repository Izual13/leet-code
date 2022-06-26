package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.collections.HashMap

@Suppress("ClassName")
class `Course Schedule` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, canFinish(2, arrayOf(intArrayOf(1, 0))))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(true, canFinish(5, arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(3, 1), intArrayOf(3, 2))))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(false, canFinish(3, arrayOf(intArrayOf(1, 0), intArrayOf(0, 2), intArrayOf(2, 1))))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(false, canFinish(3, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(0, 1))))
    }


    private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = HashMap<Int, ArrayList<Int>>()
        for ((a, b) in prerequisites) {
            val list = map.getOrDefault(a, ArrayList())
            list.add(b)
            map[a] = list
        }

        for (i in ArrayList(map.keys)) {
            if (!dfs(i, map)) {
                return false
            }
        }

        return true
    }

    private fun dfs(key: Int, map: HashMap<Int, ArrayList<Int>>, visited: HashSet<Int> = HashSet()): Boolean {
        if (visited.contains(key)) {
            return false
        }


        visited.add(key)
        for (i in map.getOrDefault(key, listOf())) {
            if (!dfs(i, map, visited)) {
                return false
            }
        }
        visited.remove(key)
        map.remove(key)
        return true
    }

}