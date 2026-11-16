package minimumoperationstoequalizesubarrays

// Time:  O((n + q) * logn)
// Space: O(nlogn)

// prefix sum, persistent segment tree, binary search
private class PersistentSegmentTree(vals: LongArray) {
    private val sortedUniqueVals: LongArray
    private val n: Int
    private val valToIdx = HashMap<Long, Int>()
    private val nodes = ArrayList<Node>()
    private val roots = ArrayList<Int>()

    init {
        sortedUniqueVals = vals.distinct().sorted().toLongArray()
        n = sortedUniqueVals.size
        for (i in 0 until n) {
            valToIdx[sortedUniqueVals[i]] = i
        }
        build(vals)
    }

    fun query(l: Int, r: Int): Long {
        var a = roots[l]
        var b = roots[r + 1]
        var leftCnt = 0L
        var leftTotal = 0L
        var medCnt = ((r - l + 1) / 2) + 1
        var left = 0
        var right = n - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            val cnt = nodes[nodes[b].left].cnt - nodes[nodes[a].left].cnt
            if (medCnt <= cnt) {
                a = nodes[a].left
                b = nodes[b].left
                right = mid
            } else {
                leftCnt += cnt
                leftTotal += nodes[nodes[b].left].total - nodes[nodes[a].left].total
                medCnt -= cnt
                a = nodes[a].right
                b = nodes[b].right
                left = mid + 1
            }
        }
        return (sortedUniqueVals[left] * leftCnt - leftTotal) +
                ((nodes[roots[r + 1]].total - nodes[roots[l]].total - leftTotal) -
                        sortedUniqueVals[left] * ((r - l + 1) - leftCnt))
    }

    private fun newNode(): Int {
        nodes.add(Node())
        return nodes.size - 1
    }

    private fun copyNode(idx: Int): Int {
        nodes.add(Node(nodes[idx].left, nodes[idx].right, nodes[idx].cnt, nodes[idx].total))
        return nodes.size - 1
    }

    private fun build(vals: LongArray) {
        var root = newNode()
        roots.add(root)
        for (x in vals) {
            root = copyNode(root)
            roots.add(root)
            var curr = root
            var left = 0
            var right = n - 1
            val i = valToIdx[x]!!
            while (left < right) {
                ++nodes[curr].cnt
                nodes[curr].total += x
                val mid = left + (right - left) / 2
                if (i <= mid) {
                    nodes[curr].left = copyNode(nodes[curr].left)
                    curr = nodes[curr].left
                    right = mid
                } else {
                    nodes[curr].right = copyNode(nodes[curr].right)
                    curr = nodes[curr].right
                    left = mid + 1
                }
            }
            ++nodes[curr].cnt
            nodes[curr].total += x
        }
    }

    private class Node(
        var left: Int = 0,
        var right: Int = 0,
        var cnt: Int = 0,
        var total: Long = 0
    )
}

class Solution {
    fun minOperations(nums: IntArray, k: Int, queries: Array<IntArray>): List<Long> {
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] +
                    (if (i - 1 >= 0 && nums[i] % k != nums[i - 1] % k) 1 else 0)
        }
        val vals = LongArray(nums.size)
        for (i in vals.indices) {
            vals[i] = (nums[i] / k).toLong()
        }
        val pst = PersistentSegmentTree(vals)
        val result = ArrayList<Long>()
        for (q in queries) {
            val s = q[0]
            val t = q[1]
            result.add(if (prefix[t + 1] - prefix[s + 1] == 0) pst.query(s, t) else -1L)
        }
        return result
    }
}
