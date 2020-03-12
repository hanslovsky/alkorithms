package me.hanslovsky.alkorithms.graph.directed.tree

import org.junit.Assert
import org.junit.Test

internal class BinaryTreeTest {
    @ExperimentalStdlibApi
    @Test
    fun testDepthFirstTraversal() {

        val left = intArrayOf(1, -1, 3, 5, -1, -1, -1)
        val right = intArrayOf(2, 4, -1, 6, -1, -1, -1)
        val tree = (left zip right).flatMap { it.toList() }.toIntArray()

        mutableListOf<Int>().let { visitedNodes ->
            val visitedNodesGroundTruth = intArrayOf(0, 1, 4, 2, 3, 5, 6)
            BinaryTree.depthFirstTraversalRecursive(left, right, 0, { visitedNodes += it })
            Assert.assertArrayEquals(visitedNodesGroundTruth, visitedNodes.toIntArray())
        }

        mutableListOf<Int>().let { visitedNodes ->
            val visitedNodesGroundTruth = intArrayOf(0, 1, 4, 2, 3, 5, 6)
            BinaryTree.depthFirstTraversal(left, right, 0) { visitedNodes += it }
            Assert.assertArrayEquals(visitedNodesGroundTruth, visitedNodes.toIntArray())
        }

        mutableListOf<Int>().let { visitedNodes ->
            val visitedNodesGroundTruth = intArrayOf(0, 1, 4, 2, 3, 5, 6)
            BinaryTree.depthFirstTraversalRecursive(tree, 0, { visitedNodes += it })
            Assert.assertArrayEquals(visitedNodesGroundTruth, visitedNodes.toIntArray())
        }

        mutableListOf<Int>().let { visitedNodes ->
            val visitedNodesGroundTruth = intArrayOf(0, 1, 4, 2, 3, 5, 6)
            BinaryTree.depthFirstTraversal(tree, 0) { visitedNodes += it }
            Assert.assertArrayEquals(visitedNodesGroundTruth, visitedNodes.toIntArray())
        }


        // these calls are necessary to cover all possible overloads
        BinaryTree.depthFirstTraversal(left, right)
        BinaryTree.depthFirstTraversalRecursive(left, right)
        BinaryTree.depthFirstTraversal(tree)
        BinaryTree.depthFirstTraversalRecursive(tree)
        BinaryTree.depthFirstTraversal(BinaryTree.IndexArrayTree(tree))
        BinaryTree.depthFirstTraversalRecursive(BinaryTree.IndexArrayTree(tree))
    }
}