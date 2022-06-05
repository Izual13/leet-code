package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Check If a Word Occurs As a Prefix of Any Word in a Sentence` {
    @Test
    fun test1() {
        Assertions.assertEquals(4, isPrefixOfWord("i love eating burger", "burg"))
    }

    private fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val array = sentence.split(" ")
        for (i in array.indices) {
            if (array[i].startsWith(searchWord)) {
                return i + 1
            }
        }
        return -1
    }
}
