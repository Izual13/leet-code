package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Valid Parentheses` {

    @Test
    fun test1() {
        Assertions.assertEquals(true, isValid("()[]{}"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, isValid("(}"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(false, isValid("]"))
    }

    private fun isValid(s: String): Boolean {
        val parentheses = ArrayDeque<Char>()
        for (it in s.toCharArray()) {
            when (it) {
                '{' -> parentheses.push(it)
                '[' -> parentheses.push(it)
                '(' -> parentheses.push(it)
                '}' -> if (!rm(parentheses, '{')) return false
                ']' -> if (!rm(parentheses, '[')) return false
                ')' -> if (!rm(parentheses, '(')) return false
            }
        }

        return parentheses.isEmpty()
    }

    private fun rm(parentheses: ArrayDeque<Char>, remove: Char): Boolean {
        return !parentheses.isEmpty() && parentheses.pop() == remove
    }


}