package me.hanslovsky.alkorithms.graph.directed

interface DirectedGraph {

    operator fun get(node: Int): IntArray

    class IntArrayDirectedGraph(private val edges: Array<IntArray>) : DirectedGraph {
        override operator fun get(node: Int): IntArray = edges[node]
    }

    companion object {

        @ExperimentalStdlibApi
        inline fun DirectedGraph.depthFirstSearch(
                from: Int,
                to: Int,
                callback: (Int) -> Unit = {})  = depthFirstSearch(from, { it == to }, callback)

        @ExperimentalStdlibApi
        inline fun DirectedGraph.depthFirstSearch(from: Int, to: (Int) -> Boolean = { false }, callback: (Int) -> Unit = {}) {
            val stack = ArrayDeque<Int>().also { it.add(from) }
            val seen = HashSet<Int>().also { it.add(from) }
            while (stack.isNotEmpty()) {
                val current = stack.removeLast()
                callback(current)
                if (to(current)) break
                val children = this[current]
                for (idx in children.size - 1 downTo  0) {
                    val child = children[idx]
                    if (child in seen)
                        continue
                    stack += child
                    seen += child
                }
            }
        }

        @ExperimentalStdlibApi
        inline fun DirectedGraph.breadthFirstSearch(
                from: Int,
                to: Int,
                callback: (Int) -> Unit = {})  = breadthFirstSearch(from, { it == to }, callback)

        @ExperimentalStdlibApi
        inline fun DirectedGraph.breadthFirstSearch(from: Int, to: (Int) -> Boolean = { false }, callback: (Int) -> Unit = {}) {
            val queue = ArrayDeque<Int>().also { it.add(from) }
            val seen = HashSet<Int>().also { it.add(from) }
            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                callback(current)
                if (to(current)) break
                val children = this[current]
                for (child in children) {
                    if (child in seen)
                        continue
                    queue += child
                    seen += child
                }
            }
        }
    }

}

@ExperimentalStdlibApi
fun main() {
    val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2),
            intArrayOf(0, 3),
            intArrayOf(3))
    val graph = DirectedGraph.IntArrayDirectedGraph(edges)
    with (DirectedGraph) {
        graph.breadthFirstSearch(2) { println(it) }
        println()
        graph.depthFirstSearch(2) { println(it) }
    }
}