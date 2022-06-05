package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Prefix and Suffix Search` {


    @Test
    fun test1() {
        val wordFilter = WordFilter(arrayOf("apple"));
        Assertions.assertEquals(0, wordFilter.f("a", "e"))
        Assertions.assertEquals(-1, wordFilter.f("ab", "e"))
    }


    private class WordFilter(words: Array<String>) {
        private val map = words.mapIndexed { index, s -> s to index }.toMap()
        private val prefixMap = HashMap<String, HashSet<String>>()
        private val suffixMap = HashMap<String, HashSet<String>>()

        init {
            for (word in words) {
                prefixMap.computeIfAbsent(word) { HashSet() }.add(word)
                suffixMap.computeIfAbsent(word) { HashSet() }.add(word)
                for (i in 1..word.lastIndex) {
                    prefixMap.computeIfAbsent(word.substring(0, i)) { HashSet() }.add(word)
                    suffixMap.computeIfAbsent(word.substring(i)) { HashSet() }.add(word)
                }
            }
        }

        fun f(prefix: String, suffix: String): Int {
            val set1 = prefixMap[prefix]
            val set2 = suffixMap[suffix]

            if (set1 == null || set2 == null) {
                return -1
            }

            val result = HashSet(set1)
            result.retainAll(set2)

            if (result.isEmpty()) {
                return -1
            }

            return map[result.maxByOrNull { map[it]!! }]!!
        }
    }
}