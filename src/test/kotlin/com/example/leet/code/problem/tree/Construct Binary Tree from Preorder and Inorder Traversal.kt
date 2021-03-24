package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger

@Suppress("ClassName")
class `Construct Binary Tree from Preorder and Inorder Traversal` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
        Assertions.assertEquals(tree?.`val`, 3)
        Assertions.assertEquals(tree?.left?.`val`, 9)
        Assertions.assertEquals(tree?.right?.`val`, 20)
        Assertions.assertEquals(tree?.right?.left?.`val`, 15)
        Assertions.assertEquals(tree?.right?.right?.`val`, 7)
    }

    private fun buildTree(
        preorder: IntArray,
        inorder: IntArray,
        preorderIndex: AtomicInteger = AtomicInteger(),
        start: Int = 0,
        end: Int = preorder.lastIndex,
        map: Map<Int, Int> = inorder.mapIndexed { i, v -> v to i }.toMap()
    ): TreeNode? {
        if (start > end || preorderIndex.get() > preorder.size) {
            return null
        }

        val root = TreeNode(preorder[preorderIndex.getAndIncrement()])

        root.left = buildTree(preorder, inorder, preorderIndex, start, map[root.`val`]!! - 1, map)
        root.right = buildTree(preorder, inorder, preorderIndex, map[root.`val`]!! + 1, end, map)

        return root
    }
}
