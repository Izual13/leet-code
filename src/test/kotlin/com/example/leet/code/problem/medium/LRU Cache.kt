package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `LRU Cache` {

    private class LRUCache(private val capacity: Int) {

        val map = LinkedHashMap<Int, Int>();

        fun get(key: Int): Int {
            val remove = map.remove(key) ?: return -1
            map[key] = remove
            return remove
        }

        fun put(key: Int, value: Int) {
            map.remove(key)
            if (map.size == capacity) {
                map.remove(map.keys.iterator().next())
            }
            map[key] = value
        }
    }

    @Test
    fun test1() {
        val lRUCache = LRUCache(2)
        lRUCache.put(1, 1)
        lRUCache.put(2, 2)
        Assertions.assertEquals(1, lRUCache.get(1))
        lRUCache.put(3, 3)
        Assertions.assertEquals(-1, lRUCache.get(2))
        lRUCache.put(4, 4)
        Assertions.assertEquals(-1, lRUCache.get(1))
        Assertions.assertEquals(3, lRUCache.get(3))
        Assertions.assertEquals(4, lRUCache.get(4))
    }

    @Test
    fun test2() {
        val lRUCache = LRUCache(2)
        Assertions.assertEquals(-1, lRUCache.get(2))
        lRUCache.put(2, 6)
        Assertions.assertEquals(-1, lRUCache.get(1))
        lRUCache.put(1, 5)
        lRUCache.put(1, 2)
        Assertions.assertEquals(2, lRUCache.get(1))
        Assertions.assertEquals(6, lRUCache.get(2))
    }
}