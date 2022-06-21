package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Find All Anagrams in a String` {

    @Test
    fun test1() {
        Assertions.assertEquals(listOf(0, 6), findAnagrams("cbaebabacd", "abc"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(listOf(0, 1, 2), findAnagrams("abab", "ab"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(listOf(1), findAnagrams("baa", "aa"))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(listOf(1, 3, 6, 7), findAnagrams("acdcaeccde", "c"))
    }


    private fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        val map = HashMap<Char, Int>()
        val tmp = HashMap<Char, Int>(map)

        for (c in p) {
            map[c] = map.getOrDefault(c, 0) + 1
            tmp[c] = 0
        }

        var start = 0
        var count = 0

        while (start <= s.length - p.length) {
            while (count != p.length && start <= s.length - p.length) {
                val c = s[start + count]
                if (tmp[c] != null) {
                    tmp[c] = tmp[c]!! + 1
                    count++

                    while (tmp[c]!! > map[c]!!) {
                        val c2 = s[start]
                        if (tmp[c2] != null) {
                            tmp[c2] = tmp[c2]!! - 1
                            start++
                            count--
                        }
                    }
                } else {
                    val c2 = s[start]
                    if (tmp[c2] != null) {
                        tmp[c2] = tmp[c2]!! - 1
                        count--
                    }
                    start++
                }
            }
            if (count == p.length) {
                result.add(start)
            }

            if(start <= s.length - p.length){
                val c2 = s[start]
                if (tmp[c2] != null) {
                    tmp[c2] = tmp[c2]!! - 1
                    count--
                }
                start++
            }
        }

        return result
    }
}