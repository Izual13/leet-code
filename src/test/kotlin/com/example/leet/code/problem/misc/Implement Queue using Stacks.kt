package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Implement Queue using Stacks` {


    @Test
    fun test1() {
        val myQueue = MyQueue()

        myQueue.push(1)
        myQueue.push(2)

        Assertions.assertEquals(1, myQueue.peek())
        Assertions.assertEquals(1, myQueue.pop())
        Assertions.assertEquals(false, myQueue.empty())
        Assertions.assertEquals(2, myQueue.peek())
        Assertions.assertEquals(2, myQueue.pop())
        Assertions.assertEquals(true, myQueue.empty())
    }


    private class MyQueue() {

        private val stack = Stack<Int>()
        private val queue = Stack<Int>()


        fun push(x: Int) {
            stack.push(x)
        }

        fun pop(): Int {
            refresh()
            return queue.pop()
        }

        fun peek(): Int {
            refresh()
            return queue.peek()
        }

        private fun refresh() {
            if (queue.isNotEmpty() || stack.isEmpty()) {
                return
            }
            while (stack.isNotEmpty()) {
                queue.push(stack.pop())
            }
        }

        fun empty(): Boolean {
            return stack.isEmpty() && queue.isEmpty()
        }

    }
}