package me.hanslovsky.alkorithms.graph.directed.tree

class BinaryTree private constructor() {
    companion object {
        @ExperimentalStdlibApi
        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversal(
                left: IntArray,
                right: IntArray,
                root: Int = 0,
                callback: (Int) -> Unit = {}) {
            val stack = ArrayList<Int>().also { it.add(root) }
            while (stack.isNotEmpty()) {
                val node = stack.removeLast()
                if (node < 0) continue
                callback(node)
                stack += right[node]
                stack += left[node]
            }
        }

        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversalRecursive(
                left: IntArray,
                right: IntArray,
                node: Int = 0,
                onEnterCallback: (Int) -> Unit = {},
                betweenChildrenCallBack: (Int) -> Unit = {},
                onExitCallback: (Int) -> Unit = {}) {
            if (node < 0) return
            onEnterCallback(node)
            depthFirstTraversalRecursive(left, right, left[node], onEnterCallback, betweenChildrenCallBack, onExitCallback)
            betweenChildrenCallBack(node)
            depthFirstTraversalRecursive(left, right, right[node], onEnterCallback, betweenChildrenCallBack, onExitCallback)
            onExitCallback(node)
        }


        @ExperimentalStdlibApi
        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversal(
                tree: IntArray,
                root: Int = 0,
                callback: ((Int) -> Unit)? = null) {
            val stack = ArrayList<Int>().also { it.add(root) }
            while (stack.isNotEmpty()) {
                val node = stack.removeLast()
                if (node < 0) continue
                callback?.invoke(node)
                val index = 2*node
                stack += tree[index+1]
                stack += tree[index]
            }
        }

        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversalRecursive(
                tree: IntArray,
                node: Int = 0,
                onEnterCallback: (Int) -> Unit = {},
                betweenChildrenCallBack: (Int) -> Unit = {},
                onExitCallback: (Int) -> Unit = {}) {
            if (node < 0) return
            onEnterCallback(node)
            val index = 2*node
            depthFirstTraversalRecursive(tree, tree[index], onEnterCallback, betweenChildrenCallBack, onExitCallback)
            betweenChildrenCallBack(node)
            depthFirstTraversalRecursive(tree, tree[index+1], onEnterCallback, betweenChildrenCallBack, onExitCallback)
            onExitCallback(node)
        }
    }
}