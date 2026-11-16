package powerupdateafterkthlargestinsertioni

// Time:  O((n + q) * log(n * q) + q * logr)
// Space: O(n + q)

class Solution {
    fun powerUpdate(nums: IntArray, p: Int, queries: Array<IntArray>): IntArray {
        val os = OrderStatisticSet()
        for (x in nums) {
            os.insert(x)
        }
        val result = IntArray(queries.size)
        var base = p.toLong()
        for (k in queries.indices) {
            val q = queries[k]
            os.insert(q[0])
            base = powMod(base, os.kthLargest(q[1]).toLong(), MOD)
            result[k] = base.toInt()
        }
        return result
    }

    private fun powMod(a0: Long, b0: Long, mod: Long): Long {
        var a = a0 % mod
        var b = b0
        var result = 1L
        while (b > 0) {
            if (b and 1L == 1L) {
                result = result * a % mod
            }
            a = a * a % mod
            b = b shr 1
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007L
    }
}

private class OrderStatisticSet {
    private class Node(val key: Int, val priority: Int) {
        var left: Node? = null
        var right: Node? = null
        var count = 1
        var size = 1
    }

    private var root: Node? = null
    private val random = java.util.Random(0)

    private fun size(node: Node?): Int = node?.size ?: 0

    private fun update(node: Node) {
        node.size = size(node.left) + size(node.right) + node.count
    }

    fun insert(key: Int) {
        root = insert(root, key)
    }

    private fun insert(node: Node?, key: Int): Node {
        if (node == null) {
            return Node(key, random.nextInt())
        }
        if (key == node.key) {
            ++node.count
            update(node)
            return node
        }
        if (key < node.key) {
            node.left = insert(node.left, key)
            if (node.left!!.priority < node.priority) {
                return rotateRight(node)
            }
        } else {
            node.right = insert(node.right, key)
            if (node.right!!.priority < node.priority) {
                return rotateLeft(node)
            }
        }
        update(node)
        return node
    }

    private fun rotateRight(node: Node): Node {
        val left = node.left!!
        node.left = left.right
        left.right = node
        update(node)
        update(left)
        return left
    }

    private fun rotateLeft(node: Node): Node {
        val right = node.right!!
        node.right = right.left
        right.left = node
        update(node)
        update(right)
        return right
    }

    fun kthLargest(k: Int): Int {
        return kth(size(root) - k + 1)
    }

    private fun kth(k0: Int): Int {
        var node = root!!
        var k = k0
        while (true) {
            val leftSize = size(node.left)
            if (k <= leftSize) {
                node = node.left!!
            } else if (k <= leftSize + node.count) {
                return node.key
            } else {
                k -= leftSize + node.count
                node = node.right!!
            }
        }
    }
}
