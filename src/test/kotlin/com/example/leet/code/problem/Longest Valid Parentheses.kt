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

    @Test
    fun test4() {
        Assertions.assertEquals(2, longestValidParentheses("()"))
    }

    private fun longestValidParentheses(s: String): Int {
        var max = 0
        val stack = LinkedList<Int>()
        for (i in s.indices) {
            val parenthesis = s[i]
            if (stack.isNotEmpty() && s[stack.peek()] == '(' && parenthesis == ')') {
                stack.poll()
                val last = stack.peek() ?: -1
                max = max(i - last, max)
            } else {
                stack.push(i)
            }
        }

        return max
    }
}