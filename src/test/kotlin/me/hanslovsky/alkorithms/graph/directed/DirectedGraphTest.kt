package me.hanslovsky.alkorithms.graph.directed

import me.hanslovsky.alkorithms.graph.directed.DirectedGraph.Companion.breadthFirstSearch
import me.hanslovsky.alkorithms.graph.directed.DirectedGraph.Companion.depthFirstSearch
import org.junit.Assert
import org.junit.Test

internal class DirectedGraphTest {

    @ExperimentalStdlibApi
    @Test
    fun testSearch() {
        val edges = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2),
                intArrayOf(0, 3),
                intArrayOf(3))
        val graph = DirectedGraph.IntArrayDirectedGraph(edges)
        ArrayList<Int>().let { visited ->
            graph.breadthFirstSearch(2) { visited += it }
            Assert.assertArrayEquals(intArrayOf(2, 0, 3, 1), visited.toIntArray())
        }
        ArrayList<Int>().let { visited ->
            graph.depthFirstSearch(2) { visited += it }
            Assert.assertArrayEquals(intArrayOf(2, 0, 1, 3), visited.toIntArray())
        }
    }

}