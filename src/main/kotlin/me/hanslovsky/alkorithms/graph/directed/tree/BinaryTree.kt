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
        inline fun preOrderTraversal(
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

        fun preOrderTraversalRecursive(
                tree: Tree,
                node: Int = 0,
                callback: (Int) -> Unit = {}) {
            if (node < 0) return
            callback(node)
            preOrderTraversalRecursive(tree, tree.left[node], callback)
            preOrderTraversalRecursive(tree, tree.right[node], callback)
        }


        @ExperimentalStdlibApi
        inline fun preOrderTraversal(
                left: IntArray,
                right: IntArray,
                root: Int = 0,
                callback: (Int) -> Unit = {}) = preOrderTraversal(LeftRightArrayTree(left, right), root, callback)

        fun preOrderTraversalRecursive(
                left: IntArray,
                right: IntArray,
                node: Int = 0,
                callback: (Int) -> Unit = {}) = preOrderTraversalRecursive(LeftRightArrayTree(left,right), node, callback)


        @ExperimentalStdlibApi
        inline fun preOrderTraversal(
                tree: IntArray,
                root: Int = 0,
                callback: (Int) -> Unit = {}) = preOrderTraversal(IndexArrayTree(tree), root, callback)

        fun preOrderTraversalRecursive(
                tree: IntArray,
                node: Int = 0,
                callback: (Int) -> Unit = {}) = preOrderTraversalRecursive(IndexArrayTree(tree), node, callback)
    }
}