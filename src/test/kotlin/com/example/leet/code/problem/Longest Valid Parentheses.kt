package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.math.max

@Suppress("ClassName")
class `Longest Valid Parentheses` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, longestValidParentheses("(()"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(4, longestValidParentheses(")()())"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(2, longestValidParentheses("()(()"))
    }

    private fun longestValidParentheses(s: String): Int {
        var start = 0
        var max = 0

        for (i in start..s.lastIndex) {
            val stack = LinkedList<Char>()
            var tmp = 0
            for (j in i..s.lastIndex) {
                val parenthesis = s[j]
                if (stack.isNotEmpty() && stack.peek() == '(' && parenthesis == ')') {
                    tmp += 2
                    stack.poll()
                } else {
                    stack.push(parenthesis)
                }

                if (stack.isEmpty()) {
                    max = max(tmp, max)
                }
            }
        }

        return max
    }
}