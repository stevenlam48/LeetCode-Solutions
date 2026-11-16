package findxsumofallklongsubarraysii

// Time:  O(nlogn)
// Space: O(n)

private data class Entry(val count: Long, val value: Int)

private class OrderedSet {
    private class Node(var key: Entry) {
        var left: Node? = null
        var right: Node? = null
        var height = 1
        var size = 1
    }

    private var root: Node? = null
    var size = 0
        private set

    private fun compare(a: Entry, b: Entry): Int {
        val countComparison = b.count.compareTo(a.count)
        return if (countComparison != 0) countComparison else b.value.compareTo(a.value)
    }

    private fun height(node: Node?): Int = node?.height ?: 0

    private fun size(node: Node?): Int = node?.size ?: 0

    private fun update(node: Node) {
        node.height = maxOf(height(node.left), height(node.right)) + 1
        node.size = size(node.left) + size(node.right) + 1
    }

    private fun rotateRight(node: Node): Node {
        val newRoot = node.left!!
        node.left = newRoot.right
        newRoot.right = node
        update(node)
        update(newRoot)
        return newRoot
    }

    private fun rotateLeft(node: Node): Node {
        val newRoot = node.right!!
        node.right = newRoot.left
        newRoot.left = node
        update(node)
        update(newRoot)
        return newRoot
    }

    private fun rebalance(node: Node): Node {
        update(node)
        val balance = height(node.left) - height(node.right)
        if (balance > 1) {
            if (height(node.left!!.left) < height(node.left!!.right)) {
                node.left = rotateLeft(node.left!!)
            }
            return rotateRight(node)
        }
        if (balance < -1) {
            if (height(node.right!!.right) < height(node.right!!.left)) {
                node.right = rotateRight(node.right!!)
            }
            return rotateLeft(node)
        }
        return node
    }

    private fun insert(node: Node?, key: Entry): Node {
        if (node == null) {
            return Node(key)
        }
        val comparison = compare(key, node.key)
        if (comparison < 0) {
            node.left = insert(node.left, key)
        } else if (comparison > 0) {
            node.right = insert(node.right, key)
        } else {
            return node
        }
        return rebalance(node)
    }

    fun insert(key: Entry) {
        root = insert(root, key)
        ++size
    }

    private fun minimum(node: Node): Node {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }

    private fun erase(node: Node?, key: Entry): Node? {
        if (node == null) {
            return null
        }
        val comparison = compare(key, node.key)
        if (comparison < 0) {
            node.left = erase(node.left, key)
        } else if (comparison > 0) {
            node.right = erase(node.right, key)
        } else {
            if (node.left == null) {
                return node.right
            }
            if (node.right == null) {
                return node.left
            }
            val successor = minimum(node.right!!)
            node.key = successor.key
            node.right = erase(node.right, successor.key)
        }
        return rebalance(node)
    }

    fun erase(key: Entry) {
        root = erase(root, key)
        --size
    }

    fun orderOfKey(key: Entry): Int {
        var current = root
        var result = 0
        while (current != null) {
            val comparison = compare(key, current.key)
            if (comparison < 0) {
                current = current.left
            } else if (comparison > 0) {
                result += size(current.left) + 1
                current = current.right
            } else {
                return result + size(current.left)
            }
        }
        return result
    }

    fun byOrder(index: Int): Entry {
        var current = root!!
        var i = index
        while (true) {
            val leftSize = size(current.left)
            if (i < leftSize) {
                current = current.left!!
            } else if (i > leftSize) {
                i -= leftSize + 1
                current = current.right!!
            } else {
                return current.key
            }
        }
    }
}

class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): LongArray {
        val orderedSet = OrderedSet()
        val counts = HashMap<Int, Long>()

        fun update(value: Int, delta: Long, current: Long): Long {
            val count = counts[value]!!
            val entry = Entry(count, value)
            var result = current
            if (delta == 1L) {
                orderedSet.insert(entry)
            }
            if (orderedSet.orderOfKey(entry) < x) {
                result += delta * count * value
                if (x < orderedSet.size) {
                    val displaced = orderedSet.byOrder(x)
                    result -= delta * displaced.count * displaced.value
                }
            }
            if (delta != 1L) {
                orderedSet.erase(entry)
            }
            return result
        }

        val result = ArrayList<Long>()
        var current = 0L
        for (i in nums.indices) {
            if (counts.containsKey(nums[i])) {
                current = update(nums[i], -1, current)
            }
            counts[nums[i]] = (counts[nums[i]] ?: 0L) + 1
            current = update(nums[i], 1, current)
            if (i < k - 1) {
                continue
            }
            result.add(current)
            val outgoing = nums[i - (k - 1)]
            current = update(outgoing, -1, current)
            counts[outgoing] = counts[outgoing]!! - 1
            if (counts[outgoing] != 0L) {
                current = update(outgoing, 1, current)
            } else {
                counts.remove(outgoing)
            }
        }
        return result.toLongArray()
    }
}
