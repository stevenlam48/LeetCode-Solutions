package findxsumofallklongsubarraysi

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val os = OrderedSet()
        val cnt = HashMap<Int, Int>()

        fun update(v: Int, d: Int, current: Int): Int {
            var curr = current
            val count = cnt[v] ?: 0
            if (d == 1) {
                os.insert(count, v)
            }
            if (os.rank(count, v) < x) {
                curr += d * count * v
                if (x < os.size) {
                    val (nc, nv) = os[x]
                    curr -= d * nc * nv
                }
            }
            if (d != 1) {
                os.erase(count, v)
            }
            return curr
        }

        val result = ArrayList<Int>()
        var curr = 0
        for (i in nums.indices) {
            if (cnt.containsKey(nums[i])) {
                curr = update(nums[i], -1, curr)
            }
            cnt[nums[i]] = (cnt[nums[i]] ?: 0) + 1
            curr = update(nums[i], 1, curr)
            if (i < k - 1) {
                continue
            }
            result.add(curr)
            val v = nums[i - (k - 1)]
            curr = update(v, -1, curr)
            val count = cnt.getValue(v) - 1
            if (count != 0) {
                cnt[v] = count
                curr = update(v, 1, curr)
            } else {
                cnt.remove(v)
            }
        }
        return result.toIntArray()
    }
}

private class OrderedSet {
    private class Node(var count: Int, var value: Int) {
        var left: Node? = null
        var right: Node? = null
        var height: Int = 1
        var size: Int = 1
    }

    private var root: Node? = null

    var size: Int = 0
        private set

    fun insert(count: Int, value: Int) {
        root = insert(root, count, value)
        ++size
    }

    fun erase(count: Int, value: Int) {
        root = erase(root, count, value)
        --size
    }

    fun rank(count: Int, value: Int): Int {
        var node = root
        var result = 0
        while (node != null) {
            val comparison = compare(count, value, node.count, node.value)
            when {
                comparison < 0 -> node = node.left
                comparison > 0 -> {
                    result += size(node.left) + 1
                    node = node.right
                }
                else -> return result + size(node.left)
            }
        }
        return result
    }

    operator fun get(index: Int): Pair<Int, Int> {
        var node = root!!
        var i = index
        while (true) {
            val leftSize = size(node.left)
            when {
                i < leftSize -> node = node.left!!
                i > leftSize -> {
                    i -= leftSize + 1
                    node = node.right!!
                }
                else -> return node.count to node.value
            }
        }
    }

    private fun insert(node: Node?, count: Int, value: Int): Node {
        if (node == null) {
            return Node(count, value)
        }
        if (compare(count, value, node.count, node.value) < 0) {
            node.left = insert(node.left, count, value)
        } else {
            node.right = insert(node.right, count, value)
        }
        return rebalance(node)
    }

    private fun erase(node: Node?, count: Int, value: Int): Node? {
        if (node == null) {
            return null
        }
        val comparison = compare(count, value, node.count, node.value)
        when {
            comparison < 0 -> node.left = erase(node.left, count, value)
            comparison > 0 -> node.right = erase(node.right, count, value)
            else -> {
                if (node.left == null) {
                    return node.right
                }
                if (node.right == null) {
                    return node.left
                }
                var successor = node.right!!
                while (successor.left != null) {
                    successor = successor.left!!
                }
                node.count = successor.count
                node.value = successor.value
                node.right = erase(node.right, successor.count, successor.value)
            }
        }
        return rebalance(node)
    }

    private fun rebalance(node: Node): Node {
        refresh(node)
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

    private fun rotateLeft(node: Node): Node {
        val result = node.right!!
        node.right = result.left
        result.left = node
        refresh(node)
        refresh(result)
        return result
    }

    private fun rotateRight(node: Node): Node {
        val result = node.left!!
        node.left = result.right
        result.right = node
        refresh(node)
        refresh(result)
        return result
    }

    private fun refresh(node: Node) {
        node.height = 1 + maxOf(height(node.left), height(node.right))
        node.size = 1 + size(node.left) + size(node.right)
    }

    private fun height(node: Node?): Int = node?.height ?: 0

    private fun size(node: Node?): Int = node?.size ?: 0

    private fun compare(count1: Int, value1: Int, count2: Int, value2: Int): Int {
        val countComparison = count2.compareTo(count1)
        return if (countComparison != 0) countComparison else value2.compareTo(value1)
    }
}
