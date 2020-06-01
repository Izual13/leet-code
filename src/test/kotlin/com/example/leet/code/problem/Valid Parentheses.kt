package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Valid Parentheses` {

    @Test
    fun test1() {
        Assertions.assertEquals(isValid("()[]{}"), true)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(isValid("(}"), false)
    }

    @Test
    fun test3() {
        Assertions.assertEquals(isValid("]"), false)
    }

    private fun isValid(s: String): Boolean {
        val parentheses = ArrayDeque<Char>()
        for (it in s.toCharArray()) {
            when (it) {
                '{' -> {
                    parentheses.push(it)
                }
                '[' -> {
                    parentheses.push(it)
                }
                '(' -> {
                    parentheses.push(it)
                }
                '}' -> {
                    if (!rm(parentheses, '{')) {
                        return false
                    }
                }
                ']' -> {
                    if (!rm(parentheses, '[')) {
                        return false
                    }
                }
                ')' -> {
                    if (!rm(parentheses, '(')) {
                        return false
                    }
                }
            }
        }

        return parentheses.isEmpty()
    }

    private fun rm(parentheses: ArrayDeque<Char>, remove: Char): Boolean {
        return !parentheses.isEmpty() && parentheses.pop() == remove
    }


}