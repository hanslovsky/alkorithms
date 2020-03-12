package me.hanslovsky.alkorithms.graph.directed.tree

class Tree private constructor() {
    companion object {
        @ExperimentalStdlibApi
        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversal(
                tree: Array<IntArray>,
                root: Int = 0,
                callback: ((Int) -> Unit)? = null) {
            val stack = ArrayList<Int>().also { it.add(root) }
            while (stack.isNotEmpty()) {
                val node = stack.removeLast()
                callback?.invoke(node)
                tree[node].let { it.forEachIndexed { index, _ -> stack += it[it.size - 1 - index] } }
            }
        }

        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversalRecursive(
                tree: Array<IntArray>,
                node: Int = 0,
                onEnterCallback: ((Int) -> Unit)? = null,
                onExitCallback: ((Int) -> Unit)? = null) {
            onEnterCallback?.invoke(node)
            tree[node].forEach { depthFirstTraversalRecursive(tree, it, onEnterCallback, onExitCallback) }
            onExitCallback?.invoke(node)
        }
    }
}
