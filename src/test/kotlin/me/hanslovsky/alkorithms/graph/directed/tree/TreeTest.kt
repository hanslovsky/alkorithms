package me.hanslovsky.alkorithms.graph.directed.tree

import org.junit.Assert
import org.junit.Test

internal class TreeTest {
    @ExperimentalStdlibApi
    @Test
    fun testDepthFirstTraversal() {

        val tree = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4),
                intArrayOf(),
                intArrayOf(5),
                intArrayOf(6),
                intArrayOf(),
                intArrayOf())

        mutableListOf<Int>().let { visitedNodes ->
            val visitedNodesGroundTruth = intArrayOf(0, 1, 4, 6, 2, 3, 5)
            Tree.depthFirstTraversalRecursive(tree, 0, onEnterCallback = { visitedNodes += it })
            Assert.assertArrayEquals(visitedNodesGroundTruth, visitedNodes.toIntArray())
        }
        mutableListOf<Int>().let { visitedNodes ->
            val visitedNodesGroundTruth = intArrayOf(6, 4, 1, 2, 5, 3, 0)
            Tree.depthFirstTraversalRecursive(tree, 0)  { visitedNodes += it }
            Assert.assertArrayEquals(visitedNodesGroundTruth, visitedNodes.toIntArray())
        }

        mutableListOf<Int>().let { visitedNodes ->
            val visitedNodesGroundTruth = intArrayOf(0, 1, 4, 6, 2, 3, 5)
            Tree.depthFirstTraversal(tree, 0) { visitedNodes += it }
            Assert.assertArrayEquals(visitedNodesGroundTruth, visitedNodes.toIntArray())
        }


        // these calls are necessary to cover all possible overloads
        Tree.depthFirstTraversalRecursive(tree)
        Tree.depthFirstTraversal(tree)
    }
}