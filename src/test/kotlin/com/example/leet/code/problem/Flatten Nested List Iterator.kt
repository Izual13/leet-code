package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Flatten Nested List Iterator` {

    @Test
    fun test1() {
        val inner = NestedInteger()
        `inner`.add(NestedInteger(4))
        `inner`.add(NestedInteger().also { it.add(NestedInteger(6)) })

        val obj = NestedIterator(listOf(NestedInteger(2), inner))
        Assertions.assertTrue(obj.hasNext())
        Assertions.assertEquals(2, obj.next())
        Assertions.assertTrue(obj.hasNext())
        Assertions.assertEquals(4, obj.next())
        Assertions.assertTrue(obj.hasNext())
        Assertions.assertEquals(6, obj.next())
        Assertions.assertFalse(obj.hasNext())
    }


    @Test
    fun test2() {
        val obj = NestedIterator(listOf(NestedInteger().also { it.add(NestedInteger()) }))
        Assertions.assertFalse(obj.hasNext())
    }

    //stub
    private class NestedInteger {
        private var value: Int? = null
        private var list: ArrayList<NestedInteger> = ArrayList()

        constructor()

        constructor(value: Int) {
            this.value = value
        }

        fun isInteger(): Boolean {
            return value != null
        }

        fun getInteger(): Int? {
            return value
        }

        fun setInteger(value: Int): Unit {
            this.value = value
        }

        fun add(ni: NestedInteger): Unit {
            this.list.add(ni)
        }

        fun getList(): List<NestedInteger> {
            return list
        }
    }

    private class NestedIterator(nestedList: List<NestedInteger>) {

        val current: LinkedList<NestedInteger> = LinkedList(nestedList)

        fun next(): Int {
            while (true) {
                val nestedIntegers = current.removeFirst()
                if (nestedIntegers.isInteger()) {
                    return nestedIntegers.getInteger()!!
                } else {
                    val list = LinkedList(nestedIntegers.getList())
                    while (list.isNotEmpty()) {
                        current.push(list.removeLast())
                    }
                }
            }
        }

        fun hasNext(): Boolean {
            while (current.isNotEmpty()) {
                val nestedIntegers = current.peekFirst()
                if (nestedIntegers.isInteger()) {
                    return true
                } else {
                    val list = LinkedList(current.removeFirst().getList())
                    while (list.isNotEmpty()) {
                        current.push(list.removeLast())
                    }
                }
            }
            return false
        }
    }


}