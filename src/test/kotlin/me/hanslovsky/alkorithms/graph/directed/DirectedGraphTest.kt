package me.hanslovsky.alkorithms.graph.directed

import me.hanslovsky.alkorithms.graph.directed.DirectedGraph.Companion.breadthFirstSearch
import me.hanslovsky.alkorithms.graph.directed.DirectedGraph.Companion.depthFirstSearch
import me.hanslovsky.alkorithms.graph.directed.DirectedGraph.Companion.shortestPath
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

    @ExperimentalStdlibApi
    @Test
    fun snakesAndLeaderShortestPathTest() {
        // very simple test
        SnakesAndLadders(0, 100).let { snakesAndLadders ->
            snakesAndLadders += 3..98
            snakesAndLadders += 99 downTo 1
            val graph = snakesAndLadders.buildGraph()
            val shortestPath = graph.shortestPath(snakesAndLadders.start, snakesAndLadders.goal)
            Assert.assertArrayEquals(intArrayOf(0, 98, 100), shortestPath)
        }

        // more complex case, check board in src/test/resources/snakes-and-ladders-board.jpg
        SnakesAndLadders(0, 100).let { snakesAndLadders ->
            // ladders
            snakesAndLadders += 1 .. 38
            snakesAndLadders += 4 .. 14
            snakesAndLadders += 9 .. 31
            snakesAndLadders += 21 .. 42
            snakesAndLadders += 28 .. 84
            snakesAndLadders += 51 .. 67
            snakesAndLadders += 72 .. 91
            snakesAndLadders += 80 .. 99

            // snakes
            snakesAndLadders += 17 downTo 7
            snakesAndLadders += 54 downTo 34
            snakesAndLadders += 62 downTo 19
            snakesAndLadders += 64 downTo 60
            snakesAndLadders += 87 downTo 36
            snakesAndLadders += 93 downTo 73
            snakesAndLadders += 95 downTo 75
            snakesAndLadders += 98 downTo 79
            val graph = snakesAndLadders.buildGraph()
            val shortestPath = graph.shortestPath(snakesAndLadders.start, snakesAndLadders.goal)
            Assert.assertNotNull(shortestPath)
            // it takes 7 rolls of the dice, i.e. 8 nodes visited
            Assert.assertEquals(8, shortestPath!!.size)
            // there are multiple possible paths that take 7 steps, so it may not make a lot
            // of sense to check for the exact array
            // this particular path is the result of deterministic internal iteration order but may change
            // if implementation details change
            Assert.assertArrayEquals(intArrayOf(0, 38, 39, 45, 67, 91, 94, 100), shortestPath)
        }

        // no solution at all
        SnakesAndLadders(0, 100).let { snakeAndLadders ->
            snakeAndLadders += 100 downTo 99
            val graph = snakeAndLadders.buildGraph()
            val shortestPath = graph.shortestPath(snakeAndLadders.start, snakeAndLadders.goal)
            Assert.assertNull(shortestPath)
        }
    }

    private class SnakesAndLadders(val start: Int = 1, val goal: Int = 100) {

        private val snakesAndLadders = HashMap<Int, Int>()

        operator fun plus(range: IntProgression) = this.also { it += range }

        operator fun plusAssign(range: IntProgression) {
            this[range.first] = range.last
        }

        operator fun set(from: Int, to: Int) {
            require(from in start .. goal) {"from=$from ${start .. goal}"}
            require(to in start .. goal) {"to=$to ${start .. goal}"}
            require(from != to) { "from=$from to=$to" }
            snakesAndLadders[from] = to
        }

        fun buildGraph(vararg possibleRolls: Int = IntArray(6) { it + 1 }): DirectedGraph {
            val validFields = start .. goal
            val edges = validFields
                    .map { field ->
                        possibleRolls
                                .map { roll ->
                                    val pos = field + roll
                                    snakesAndLadders[pos] ?: pos
                                }
                                .filter { it in validFields }
                                .toIntArray()
                    }
                    .toTypedArray()
            return DirectedGraph.IntArrayDirectedGraph(edges)
        }
    }

}