package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Median of Two Sorted Arrays` {

    @Test
    fun test1() {
        Assertions.assertEquals(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)), 2.0)
    }

    @Test
    fun test2() {
        Assertions.assertEquals(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), 2.5)
    }

    @Test
    fun test3() {
        Assertions.assertEquals(findMedianSortedArrays(intArrayOf(), intArrayOf(1)), 1.0)
    }

    @Test
    fun test4() {
        Assertions.assertEquals(findMedianSortedArrays(intArrayOf(3), intArrayOf(-2, -1)), -1.0)
    }

    @Test
    fun test5() {
        Assertions.assertEquals(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(1, 1)), 1.0)
    }

    @Test
    fun test6() {
        Assertions.assertEquals(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(-1, 3)), 1.5)
    }

    private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var even = (nums1.size + nums2.size) % 2 == 0
        var average = (nums1.size + nums2.size) / 2 + (if (even) 0 else 1)
        var index = 0
        var i = 0
        var j = 0
        var result = 0.0
        while (nums1.size != i || nums2.size != j) {
            var x = 0
            when {
                nums1.size == i -> {
                    x = nums2[j]
                    j++
                }
                nums2.size == j -> {
                    x = nums1[i]
                    i++
                }
                nums1[i] >= nums2[j] -> {
                    x = nums2[j]
                    j++
                }
                else -> {
                    x = nums1[i]
                    i++
                }
            }
            index++

            if (index == average) {
                if (even) {
                    val y = when {
                        nums1.size == i -> {
                            nums2[j]
                        }
                        nums2.size == j -> {
                            nums1[i]
                        }
                        nums1[i] >= nums2[j] -> {
                            nums2[j]
                        }
                        else -> {
                            nums1[i]
                        }
                    }

                    result = (x + y) / 2.0

                } else {
                    result = x + 0.0
                }
                break
            }
        }

        return result
    }
}
