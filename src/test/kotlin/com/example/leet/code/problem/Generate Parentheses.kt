package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Generate Parentheses` {


    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf("((()))", "(()())", "(())()", "()(())", "()()()"), generateParenthesis(3))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf("()"), generateParenthesis(1))
    }


    private fun generateParenthesis(n: Int, str: String = "", start: Int = 0, end: Int = 0, result: MutableList<String> = mutableListOf()): List<String> {
        if (start + end == n * 2) {
            result.add(str)
            return result
        }


        if (start == n) {
            generateParenthesis(n, "$str)", start, end + 1, result)
            return result
        }

        generateParenthesis(n, "$str(", start + 1, end, result)

        if (start > end) {
            generateParenthesis(n, "$str)", start, end + 1, result)
        }

        return result
    }
}