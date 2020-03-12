package me.hanslovsky.alkorithms.graph.directed.tree

class BinaryTree private constructor() {

    interface Tree {
        val left: ChildIndex
        val right: ChildIndex
    }

    interface ChildIndex {
        operator fun get(node: Int): Int
    }

    class IndexArrayTree(private val tree: IntArray) : Tree {
        override val left = object : ChildIndex { override fun get(node: Int) = tree[2*node] }
        override val right = object : ChildIndex { override fun get(node: Int) = tree[2*node+1] }
    }

    class LeftRightArrayTree(left: IntArray, right: IntArray) : Tree {
        override val left = object : ChildIndex { override fun get(node: Int) = left[node] }
        override val right = object : ChildIndex { override fun get(node: Int) = right[node] }
    }



    companion object {
        @ExperimentalStdlibApi
        @JvmStatic
        @JvmOverloads
        inline fun depthFirstTraversal(
                tree: Tree,
                root: Int = 0,
                callback: (Int) -> Unit = {}) {
            val stack = ArrayList<Int>().also { it.add(root) }
            while (stack.isNotEmpty()) {
                val node = stack.removeLast()
                if (node < 0) continue
                callback(node)
                stack += tree.right[node]
                stack += tree.left[node]
            }
        }

        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversalRecursive(
                tree: Tree,
                node: Int = 0,
                onEnterCallback: (Int) -> Unit = {},
                betweenChildrenCallBack: (Int) -> Unit = {},
                onExitCallback: (Int) -> Unit = {}) {
            if (node < 0) return
            onEnterCallback(node)
            depthFirstTraversalRecursive(tree, tree.left[node], onEnterCallback, betweenChildrenCallBack, onExitCallback)
            betweenChildrenCallBack(node)
            depthFirstTraversalRecursive(tree, tree.right[node], onEnterCallback, betweenChildrenCallBack, onExitCallback)
            onExitCallback(node)
        }


        @ExperimentalStdlibApi
        @JvmStatic
        @JvmOverloads
        inline fun depthFirstTraversal(
                left: IntArray,
                right: IntArray,
                root: Int = 0,
                callback: (Int) -> Unit = {}) = depthFirstTraversal(LeftRightArrayTree(left, right), root, callback)

        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversalRecursive(
                left: IntArray,
                right: IntArray,
                node: Int = 0,
                onEnterCallback: (Int) -> Unit = {},
                betweenChildrenCallBack: (Int) -> Unit = {},
                onExitCallback: (Int) -> Unit = {}) = depthFirstTraversalRecursive(LeftRightArrayTree(left,right), node, onEnterCallback, betweenChildrenCallBack, onExitCallback)


        @ExperimentalStdlibApi
        @JvmStatic
        @JvmOverloads
        inline fun depthFirstTraversal(
                tree: IntArray,
                root: Int = 0,
                callback: (Int) -> Unit = {}) = depthFirstTraversal(IndexArrayTree(tree), root, callback)

        @JvmStatic
        @JvmOverloads
        fun depthFirstTraversalRecursive(
                tree: IntArray,
                node: Int = 0,
                onEnterCallback: (Int) -> Unit = {},
                betweenChildrenCallBack: (Int) -> Unit = {},
                onExitCallback: (Int) -> Unit = {}) = depthFirstTraversalRecursive(IndexArrayTree(tree), node, onEnterCallback, betweenChildrenCallBack, onExitCallback)
    }
}