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


    private fun duplicateZeros(arr: IntArray): Unit {
        var count = arr.count { it == 0 }
        val size = arr.size

        for (i in arr.lastIndex downTo 0) {
            if (count == 0) {
                return
            }

            if (arr[i] == 0) {
                if (i + count < size) {
                    arr[i + count] = arr[i]
                }
                count--
                if (i + count < size) {
                    arr[i + count] = arr[i]
                }
                continue
            }

            if (i + count < size) {
                arr[i + count] = arr[i]
            }


            println(arr.contentToString())

        }

        println(arr.contentToString())
    }
}