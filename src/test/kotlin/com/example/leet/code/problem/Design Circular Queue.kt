package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Design Circular Queue` {


    @Test
    fun test1() {
        val myCircularQueue = MyCircularQueue(3)
        Assertions.assertEquals(true, myCircularQueue.enQueue(1))
        Assertions.assertEquals(true, myCircularQueue.enQueue(2))
        Assertions.assertEquals(true, myCircularQueue.enQueue(3))
        Assertions.assertEquals(false, myCircularQueue.enQueue(4))
        Assertions.assertEquals(3, myCircularQueue.Rear())
        Assertions.assertEquals(true, myCircularQueue.isFull())
        Assertions.assertEquals(true, myCircularQueue.deQueue())
        Assertions.assertEquals(true, myCircularQueue.enQueue(4))
        Assertions.assertEquals(4, myCircularQueue.Rear())

        Assertions.assertEquals(false, myCircularQueue.isEmpty())
        Assertions.assertEquals(2, myCircularQueue.Front())
        Assertions.assertEquals(true, myCircularQueue.deQueue())
        Assertions.assertEquals(3, myCircularQueue.Front())
        Assertions.assertEquals(true, myCircularQueue.deQueue())
        Assertions.assertEquals(4, myCircularQueue.Front())
        Assertions.assertEquals(true, myCircularQueue.deQueue())
        Assertions.assertEquals(false, myCircularQueue.deQueue())
        Assertions.assertEquals(true, myCircularQueue.isEmpty())
    }


    private class MyCircularQueue(k: Int) {

        private val array = IntArray(k)
        private var start = 0
        private var end = -1
        private var count = 0

        fun enQueue(value: Int): Boolean {
            if (count == array.size) {
                return false
            }
            end = (end + 1) % array.size
            array[end] = value
            count++
            return true
        }

        fun deQueue(): Boolean {
            if (count == 0) {
                return false
            }

            if (start == array.lastIndex) {
                start = 0
            } else {
                start++
            }

            count--
            return true
        }

        fun Front(): Int {
            if (count == 0) {
                return -1
            }
            return array[start]
        }

        fun Rear(): Int {
            if (count == 0) {
                return -1
            }
            return array[end]
        }

        fun isEmpty(): Boolean {
            return count == 0
        }

        fun isFull(): Boolean {
            return count == array.size
        }
    }
}