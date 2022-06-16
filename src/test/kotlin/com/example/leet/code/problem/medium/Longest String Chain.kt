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
        Assertions.assertEquals(5, longestStrChain(arrayOf("xbc","pcxbcf","xb","cxbc","pcxbc")))
    }


    private fun longestStrChain(words: Array<String>): Int {
        val map = words.asSequence().groupBy { it.length }.toSortedMap()
        var result = 1
        for (word in words) {
            result = max(result, longestWord(word, map).length - word.length)
        }

        return result+1
    }

    private fun longestWord(current: String, map: Map<Int, List<String>>): String {
        val list = map[current.length + 1] ?: return current
        var result = current
        for (word in list) {
            var errorCount = 0
            var startShort = 0
            var startLong = 0
            while (startLong <= word.lastIndex) {
                if (errorCount > 1) {
                    break
                }

                if (startLong == word.lastIndex) {
                    val tmp = longestWord(word, map)
                    if (tmp.length > result.length) {
                        result = tmp
                    }
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
        }

        return result
    }
}