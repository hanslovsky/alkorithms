package me.hanslovsky.alkorithms.graph.directed.tree

class Tree private constructor() {
    companion object {
        @ExperimentalStdlibApi
        inline fun depthFirstTraversal(
                tree: Array<IntArray>,
                root: Int = 0,
                callback: (Int) -> Unit = {}) {
            val stack = ArrayList<Int>().also { it.add(root) }
            while (stack.isNotEmpty()) {
                val node = stack.removeLast()
                callback(node)
                tree[node].let { it.forEachIndexed { index, _ -> stack += it[it.size - 1 - index] } }
            }
        }

        fun depthFirstTraversalRecursive(
                tree: Array<IntArray>,
                node: Int = 0,
                onEnterCallback: (Int) -> Unit = {},
                onExitCallback: (Int) -> Unit = {}) {
            onEnterCallback(node)
            tree[node].forEach { depthFirstTraversalRecursive(tree, it, onEnterCallback, onExitCallback) }
            onExitCallback(node)
        }
    }
}
