package me.hanslovsky.alkorithms.graph.directed.tree

import org.junit.Assert
import org.junit.Test

internal class BinaryTreeTest {
    @ExperimentalStdlibApi
    @Test
    fun testPreOrderTraversal() {

        val left = intArrayOf(1, -1, 3, 5, -1, -1, -1)
        val right = intArrayOf(2, 4, -1, 6, -1, -1, -1)
        val tree = (left zip right).flatMap { it.toList() }.toIntArray()

        val preOrderTraversalGroundTruth = intArrayOf(0, 1, 4, 2, 3, 5, 6)

        mutableListOf<Int>().let { visitedNodes ->
            BinaryTree.preOrderTraversalRecursive(left, right, 0) { visitedNodes += it }
            Assert.assertArrayEquals(preOrderTraversalGroundTruth, visitedNodes.toIntArray())
        }

        mutableListOf<Int>().let { visitedNodes ->
            BinaryTree.preOrderTraversal(left, right, 0) { visitedNodes += it }
            Assert.assertArrayEquals(preOrderTraversalGroundTruth, visitedNodes.toIntArray())
        }

        mutableListOf<Int>().let { visitedNodes ->
            BinaryTree.preOrderTraversalRecursive(tree, 0) { visitedNodes += it }
            Assert.assertArrayEquals(preOrderTraversalGroundTruth, visitedNodes.toIntArray())
        }

        mutableListOf<Int>().let { visitedNodes ->
            BinaryTree.preOrderTraversal(tree, 0) { visitedNodes += it }
            Assert.assertArrayEquals(preOrderTraversalGroundTruth, visitedNodes.toIntArray())
        }

    }
}