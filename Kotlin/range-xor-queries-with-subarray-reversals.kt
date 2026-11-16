package rangexorquerieswithsubarrayreversals
// Time:  O(n + qlogn)
// Space: O(n)
import kotlin.random.Random

class Solution {
    private class TreapNode(var value: Int) {
        var prior = Random.nextInt(Int.MAX_VALUE)
        var cnt = 1
        var xorSum = value
        var rev = false
        var left: TreapNode? = null
        var right: TreapNode? = null
    }

    fun getResults(nums: IntArray, queries: Array<IntArray>): IntArray {
        var root = build(nums, 0, nums.size)
        val result = mutableListOf<Int>()
        for (q in queries) {
            when (q[0]) {
                1 -> {
                    val first = split(root, q[1])
                    val second = split(first.second, 1)
                    val mid = second.first!!
                    mid.value = q[2]
                    update(mid)
                    root = merge(merge(first.first, mid), second.second)
                }
                2 -> {
                    val first = split(root, q[1])
                    val second = split(first.second, q[2] - q[1] + 1)
                    result.add(xorSum(second.first))
                    root = merge(merge(first.first, second.first), second.second)
                }
                3 -> {
                    val first = split(root, q[1])
                    val second = split(first.second, q[2] - q[1] + 1)
                    val mid = second.first!!
                    mid.rev = !mid.rev
                    root = merge(merge(first.first, second.first), second.second)
                }
            }
        }
        return result.toIntArray()
    }

    private fun cnt(node: TreapNode?): Int = node?.cnt ?: 0

    private fun xorSum(node: TreapNode?): Int = node?.xorSum ?: 0

    private fun update(node: TreapNode?) {
        if (node != null) {
            node.cnt = cnt(node.left) + cnt(node.right) + 1
            node.xorSum = node.value xor xorSum(node.left) xor xorSum(node.right)
        }
    }

    private fun push(node: TreapNode?) {
        if (node?.rev == true) {
            node.rev = false
            val left = node.left
            node.left = node.right
            node.right = left
            node.left?.let { it.rev = !it.rev }
            node.right?.let { it.rev = !it.rev }
        }
    }

    private fun merge(left: TreapNode?, right: TreapNode?): TreapNode? {
        push(left)
        push(right)
        if (left == null || right == null) {
            return left ?: right
        }
        val result: TreapNode
        if (left.prior > right.prior) {
            left.right = merge(left.right, right)
            result = left
        } else {
            right.left = merge(left, right.left)
            result = right
        }
        update(result)
        return result
    }

    private fun split(node: TreapNode?, key: Int, add: Int = 0): Pair<TreapNode?, TreapNode?> {
        if (node == null) {
            return null to null
        }
        push(node)
        val currentKey = add + cnt(node.left)
        val result: Pair<TreapNode?, TreapNode?>
        if (key <= currentKey) {
            val parts = split(node.left, key, add)
            node.left = parts.second
            result = parts.first to node
        } else {
            val parts = split(node.right, key, add + 1 + cnt(node.left))
            node.right = parts.first
            result = node to parts.second
        }
        update(node)
        return result
    }

    private fun heapify(node: TreapNode?) {
        if (node == null) {
            return
        }
        var maximum = node
        if (node.left != null && node.left!!.prior > maximum.prior) {
            maximum = node.left!!
        }
        if (node.right != null && node.right!!.prior > maximum.prior) {
            maximum = node.right!!
        }
        if (maximum !== node) {
            val priority = node.prior
            node.prior = maximum.prior
            maximum.prior = priority
            heapify(maximum)
        }
    }

    private fun build(values: IntArray, i: Int, n: Int): TreapNode? {
        if (n == 0) {
            return null
        }
        val mid = n / 2
        val node = TreapNode(values[i + mid])
        node.left = build(values, i, mid)
        node.right = build(values, i + mid + 1, n - mid - 1)
        heapify(node)
        update(node)
        return node
    }
}
