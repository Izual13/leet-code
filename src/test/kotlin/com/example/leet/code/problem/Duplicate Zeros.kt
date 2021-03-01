package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Duplicate Zeros` {

    @Test
    fun test1() {
        val arr = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
        duplicateZeros(arr)

        Assertions.assertArrayEquals(intArrayOf(1, 0, 0, 2, 3, 0, 0, 4), arr)
    }

    @Test
    fun test2() {
        val arr = intArrayOf(1, 2, 3)
        duplicateZeros(arr)

        Assertions.assertArrayEquals(intArrayOf(1, 2, 3), arr)
    }

    @Test
    fun test3() {
        val arr = intArrayOf(8, 4, 5, 0, 0, 0, 0, 7)
        duplicateZeros(arr)
        Assertions.assertArrayEquals(intArrayOf(8, 4, 5, 0, 0, 0, 0, 0), arr)
    }

    @Test
    fun test4() {
        val arr = intArrayOf(8, 4, 5, 0, 0, 1, 2, 3, 4, 5)
        duplicateZeros(arr)
        Assertions.assertArrayEquals(intArrayOf(8, 4, 5, 0, 0, 0, 0, 1, 2, 3), arr)
    }

    @Test
    fun test5() {
        val arr = intArrayOf(1, 0, 2, 0, 1)
        duplicateZeros(arr)
        Assertions.assertArrayEquals(intArrayOf(1, 0, 0, 2, 0), arr)
    }

    @Test
    fun test6() {
        val arr = intArrayOf(0, 1, 7, 6, 0, 2, 0, 7)
        duplicateZeros(arr)
        println(arr.contentToString())
        Assertions.assertArrayEquals(intArrayOf(0, 0, 1, 7, 6, 0, 0, 2), arr)
    }

    @Test
    fun test7() {
        val arr = intArrayOf(8, 4, 5, 0, 0, 0, 0, 7)
        duplicateZeros(arr)
        println(arr.contentToString())
        Assertions.assertArrayEquals(intArrayOf(8, 4, 5, 0, 0, 0, 0, 0), arr)
    }


    private fun duplicateZeros(arr: IntArray): Unit {
        val count = arr.count { it == 0 }
        val size = arr.size
        var end = size - 1
        var newEnd = size + count - 1

        while (end != newEnd) {

            if (newEnd < size) {
                arr[newEnd] = arr[end]
            }
            newEnd--
            if (arr[end] == 0) {
                if (newEnd < size) {
                    arr[newEnd] = arr[end]
                }
                newEnd--
            }
            end--
        }
    }
}