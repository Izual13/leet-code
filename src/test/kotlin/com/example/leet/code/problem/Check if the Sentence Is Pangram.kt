package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Check if the Sentence Is Pangram` {

    @Test
    fun test1() {
        Assertions.assertTrue(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
    }

    @Test
    fun test2() {
        Assertions.assertFalse(checkIfPangram("a"))
    }


    private fun checkIfPangram(sentence: String): Boolean {
        val array = BooleanArray(26)
        for (i in sentence) {
            array[i.code - 'a'.code] = true
        }

        return array.count { it } == 26
    }
}