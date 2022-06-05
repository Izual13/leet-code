package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Min Stack` {

    class MinStack {

        private val values = Stack<Int>()
        private val minStack = Stack<Int>()

        fun push(x: Int) {
            values.push(x)
            if (minStack.empty() || minStack.peek() >= x) {
                minStack.push(x)
            }
        }

        fun pop() {
            if (minStack.peek() == values.pop()) {
                minStack.pop()
            }
        }

        fun top(): Int {
            return values.peek()
        }

        fun getMin(): Int {
            return minStack.peek()
        }
    }

    @Test
    fun test1() {
        val minStack = MinStack()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)

        Assertions.assertEquals(-3, minStack.getMin())
        minStack.pop()
        Assertions.assertEquals(0, minStack.top())
        Assertions.assertEquals(-2, minStack.getMin())
    }

}