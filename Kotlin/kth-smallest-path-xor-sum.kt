package kthsmallestpathxorsum

// Time:  O(n * (logn)^2 + qlogn)
// Space: O(n + q)

class Solution {
    fun kthSmallest(par: IntArray, vals: IntArray, queries: Array<IntArray>): IntArray {
        val adj = Array(par.size) { mutableListOf<Int>() }
        for (u in par.indices) {
            val p = par[u]
            if (p != -1) {
                adj[p].add(u)
            }
        }
        val lookup = Array(adj.size) { mutableListOf<Int>() }
        for (i in queries.indices) {
            lookup[queries[i][0]].add(i)
        }
        val os = Array(adj.size) { OrderedSet() }
        val idxs = IntArray(adj.size) { it }
        val result = IntArray(queries.size) { -1 }
        val stk = ArrayDeque<Triple<Int, Int, Int>>()
        stk.addLast(Triple(1, 0, 0))
        while (stk.isNotEmpty()) {
            val (step, u, previous) = stk.removeLast()
            if (step == 1) {
                val curr = previous xor vals[u]
                os[idxs[u]].insert(curr)
                stk.addLast(Triple(2, u, curr))
                for (v in adj[u]) {
                    stk.addLast(Triple(1, v, curr))
                }
            } else {
                for (v in adj[u]) {
                    var i = idxs[u]
                    var j = idxs[v]
                    if (os[i].size < os[j].size) {
                        val tmp = i
                        i = j
                        j = tmp
                    }
                    os[j].forEach { os[i].insert(it) }
                    idxs[u] = i
                }
                for (i in lookup[u]) {
                    if (queries[i][1] - 1 < os[idxs[u]].size) {
                        result[i] = os[idxs[u]].select(queries[i][1] - 1)
                    }
                }
            }
        }
        return result
    }

    private class OrderedSet {
        private class Node(val value: Int) {
            var left: Node? = null
            var right: Node? = null
            var height = 1
            var size = 1
        }

        private var root: Node? = null
        val size: Int
            get() = root?.size ?: 0

        fun insert(value: Int) {
            root = insert(root, value)
        }

        fun select(index: Int): Int {
            var node = root!!
            var k = index
            while (true) {
                val leftSize = node.left?.size ?: 0
                if (k < leftSize) {
                    node = node.left!!
                } else if (k > leftSize) {
                    k -= leftSize + 1
                    node = node.right!!
                } else {
                    return node.value
                }
            }
        }

        fun forEach(action: (Int) -> Unit) {
            fun visit(node: Node?) {
                if (node == null) return
                visit(node.left)
                action(node.value)
                visit(node.right)
            }
            visit(root)
        }

        private fun insert(node: Node?, value: Int): Node {
            if (node == null) return Node(value)
            if (value < node.value) {
                node.left = insert(node.left, value)
            } else if (value > node.value) {
                node.right = insert(node.right, value)
            } else {
                return node
            }
            update(node)
            val balance = height(node.left) - height(node.right)
            if (balance > 1) {
                if (value > node.left!!.value) {
                    node.left = rotateLeft(node.left!!)
                }
                return rotateRight(node)
            }
            if (balance < -1) {
                if (value < node.right!!.value) {
                    node.right = rotateRight(node.right!!)
                }
                return rotateLeft(node)
            }
            return node
        }

        private fun rotateLeft(x: Node): Node {
            val y = x.right!!
            x.right = y.left
            y.left = x
            update(x)
            update(y)
            return y
        }

        private fun rotateRight(x: Node): Node {
            val y = x.left!!
            x.left = y.right
            y.right = x
            update(x)
            update(y)
            return y
        }

        private fun update(node: Node) {
            node.height = 1 + maxOf(height(node.left), height(node.right))
            node.size = 1 + (node.left?.size ?: 0) + (node.right?.size ?: 0)
        }

        private fun height(node: Node?): Int = node?.height ?: 0
    }
}
