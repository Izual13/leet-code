package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Group Anagrams` {

    @Test
    fun test1() {
        val groupAnagrams = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        Assertions.assertEquals(3, groupAnagrams.size)
        Assertions.assertEquals(arrayListOf("eat", "tea", "ate"), groupAnagrams[0])
        Assertions.assertEquals(arrayListOf("bat"), groupAnagrams[1])
        Assertions.assertEquals(arrayListOf("tan", "nat"), groupAnagrams[2])
    }

    @Test
    fun test2() {
        val groupAnagrams = groupAnagrams(arrayOf(""))
        Assertions.assertEquals(1, groupAnagrams.size)
        Assertions.assertEquals(arrayListOf(""), groupAnagrams[0])
    }

    @Test
    fun test3() {
        val groupAnagrams = groupAnagrams(arrayOf("a"))
        Assertions.assertEquals(1, groupAnagrams.size)
        Assertions.assertEquals(arrayListOf("a"), groupAnagrams[0])
    }


    private fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, ArrayList<String>>()
        for (s in strs) {
            val toCharArray = s.toCharArray()
            toCharArray.sort()
            val list = map.computeIfAbsent(String(toCharArray)) { ArrayList() }

            list.add(s)
        }

        return map.values.toList()
    }
}