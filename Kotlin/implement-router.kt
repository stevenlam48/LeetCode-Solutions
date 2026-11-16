package implementrouter

// Time:  ctor:          O(1)
//        addPacket:     O(logn)
//        forwardPacket: O(logn)
//        getCount:      O(logn)
// Space: O(n)

// queue, ordered set
class Router(private val size_: Int) {
    private val q_ = ArrayDeque<Triple<Int, Int, Int>>()
    private val lookup_ = HashMap<Int, OrderedSet>()

    fun addPacket(src: Int, dest: Int, timestamp: Int): Boolean {
        val set = lookup_.getOrPut(dest) { OrderedSet() }
        if (!set.insert(Pair(timestamp, src))) {
            return false
        }
        if (q_.size == size_) {
            val (s, d, t) = q_.removeFirst()
            lookup_[d]?.erase(Pair(t, s))
        }
        q_.addLast(Triple(src, dest, timestamp))
        return true
    }

    fun forwardPacket(): IntArray {
        if (q_.isEmpty()) {
            return IntArray(0)
        }
        val (s, d, t) = q_.removeFirst()
        lookup_[d]?.erase(Pair(t, s))
        return intArrayOf(s, d, t)
    }

    fun getCount(dest: Int, startTime: Int, endTime: Int): Int {
        val set = lookup_.getOrPut(dest) { OrderedSet() }
        return set.orderOfKey(Pair(endTime + 1, 0)) -
            set.orderOfKey(Pair(startTime, 0))
    }

    private class OrderedSet {
        private class Node(val key: Pair<Int, Int>) {
            var left: Node? = null
            var right: Node? = null
            var height: Int = 1
            var size: Int = 1
        }

        private var root: Node? = null
        private var inserted: Boolean = false

        fun insert(key: Pair<Int, Int>): Boolean {
            inserted = false
            root = insert(root, key)
            return inserted
        }

        fun erase(key: Pair<Int, Int>) {
            root = erase(root, key)
        }

        fun orderOfKey(key: Pair<Int, Int>): Int = orderOfKey(root, key)

        private fun compare(a: Pair<Int, Int>, b: Pair<Int, Int>): Int =
            if (a.first != b.first) a.first.compareTo(b.first)
            else a.second.compareTo(b.second)

        private fun height(node: Node?): Int = node?.height ?: 0

        private fun size(node: Node?): Int = node?.size ?: 0

        private fun update(node: Node) {
            node.height = 1 + maxOf(height(node.left), height(node.right))
            node.size = 1 + size(node.left) + size(node.right)
        }

        private fun balanceFactor(node: Node): Int =
            height(node.left) - height(node.right)

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

        private fun rebalance(node: Node): Node {
            update(node)
            val bf = balanceFactor(node)
            if (bf > 1) {
                if (balanceFactor(node.left!!) < 0) {
                    node.left = rotateLeft(node.left!!)
                }
                return rotateRight(node)
            }
            if (bf < -1) {
                if (balanceFactor(node.right!!) > 0) {
                    node.right = rotateRight(node.right!!)
                }
                return rotateLeft(node)
            }
            return node
        }

        private fun insert(node: Node?, key: Pair<Int, Int>): Node? {
            if (node == null) {
                inserted = true
                return Node(key)
            }
            val cmp = compare(key, node.key)
            when {
                cmp < 0 -> node.left = insert(node.left, key)
                cmp > 0 -> node.right = insert(node.right, key)
                else -> return node
            }
            return rebalance(node)
        }

        private fun erase(node: Node?, key: Pair<Int, Int>): Node? {
            if (node == null) {
                return null
            }
            val cmp = compare(key, node.key)
            if (cmp < 0) {
                node.left = erase(node.left, key)
            } else if (cmp > 0) {
                node.right = erase(node.right, key)
            } else {
                if (node.left == null) {
                    return node.right
                }
                if (node.right == null) {
                    return node.left
                }
                val successor = minNode(node.right!!)
                node.right = erase(node.right, successor.key)
                val replacement = Node(successor.key)
                replacement.left = node.left
                replacement.right = node.right
                return rebalance(replacement)
            }
            return rebalance(node)
        }

        private fun minNode(node: Node): Node {
            var current = node
            while (current.left != null) {
                current = current.left!!
            }
            return current
        }

        private fun orderOfKey(node: Node?, key: Pair<Int, Int>): Int {
            if (node == null) {
                return 0
            }
            val cmp = compare(key, node.key)
            return when {
                cmp < 0 -> orderOfKey(node.left, key)
                cmp > 0 -> size(node.left) + 1 + orderOfKey(node.right, key)
                else -> size(node.left)
            }
        }
    }
}
