package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Longest String Chain` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca")))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(5, longestStrChain(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(1, longestStrChain(arrayOf("abcd", "dbqca")))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(2, longestStrChain(arrayOf("a", "b", "ab", "bac")))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(4, longestStrChain(arrayOf("a","ab","ac","bd","abc","abd","abdd")))
    }


    private fun longestStrChain(words: Array<String>): Int {
        val map = words.asSequence().groupBy { it.length }.toSortedMap()
        val cache = HashMap<String, String>()
        var result = 0
        for (word in words) {
            result = max(result, longestWord(word, map, cache).length - word.length)
        }

        return result + 1
    }

    private fun longestWord(current: String, map: Map<Int, List<String>>, cache: HashMap<String, String>): String {
        val list = map[current.length + 1] ?: return current

        val cached = cache[current]
        if (cached != null) {
            return cached
        }

        var result = current
        for (word in list) {
            var errorCount = 0
            var startShort = 0
            var startLong = 0
            while (startLong <= word.lastIndex) {
                if (errorCount > 1 || (errorCount==0 && startLong == word.lastIndex)) {
                    break
                }

                if (current[startShort] != word[startLong]) {
                    errorCount++
                    startLong++
                } else {
                    startShort++
                    startLong++
                }

            }

            if (errorCount <= 1) {
                val tmp = longestWord(word, map, cache)
                if (tmp.length > result.length) {
                    result = tmp
                }
                break
            }
        }

        cache[current] = result

        return result
    }
}