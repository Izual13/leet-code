package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `N-ary Tree Preorder Traversal` {

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    @Test
    fun test1() {
        val root = Node(1)
        val n1 = Node(2)
        val n2 = Node(3)
        val n3 = Node(4)
        val n4 = Node(5)
        val n5 = Node(6)

        root.children = listOf(n2, n1, n3)
        n2.children = listOf(n4, n5)

        Assertions.assertEquals(arrayListOf(1, 3, 5, 6, 2, 4), preorder(root))
    }


    private fun preorder(root: Node?, result: ArrayList<Int> = ArrayList()): List<Int> {
        if (root == null) {
            return result
        }

        result.add(root.`val`)

        for (child in root.children) {
            preorder(child, result)
        }

        return result
    }
}
