package findxvalueofarrayii

// Time:  O(n * k + q * k * logn)
// Space: O(n * k)

private class SegmentTree(
    n: Int,
    private val buildFn: (Int) -> IntArray,
    private val updateFn: (Int) -> IntArray,
    private val queryFn: (IntArray, IntArray) -> IntArray
) {
    private val base: Int
    private val tree: Array<IntArray>

    init {
        var size = 1
        while (size < n) {
            size = size shl 1
        }
        base = size
        tree = Array(base * 2) { IntArray(0) }
        for (i in base until base + n) {
            tree[i] = buildFn(i - base)
        }
        for (i in base - 1 downTo 1) {
            tree[i] = queryFn(tree[i shl 1], tree[(i shl 1) + 1])
        }
    }

    fun update(i: Int, value: Int) {
        var x = base + i
        tree[x] = updateFn(value)
        while (x > 1) {
            x = x shr 1
            tree[x] = queryFn(tree[x shl 1], tree[(x shl 1) + 1])
        }
    }

    fun query(left: Int, right: Int): IntArray {
        var l = left + base
        var r = right + base
        var leftResult = IntArray(0)
        var rightResult = IntArray(0)
        while (l <= r) {
            if (l and 1 == 1) {
                leftResult = queryFn(leftResult, tree[l])
                ++l
            }
            if (r and 1 == 0) {
                rightResult = queryFn(tree[r], rightResult)
                --r
            }
            l = l shr 1
            r = r shr 1
        }
        return queryFn(leftResult, rightResult)
    }
}

class Solution {
    fun resultArray(nums: IntArray, k: Int, queries: Array<IntArray>): IntArray {
        fun build(i: Int): IntArray {
            val x = nums[i] % k
            val counts = IntArray(k + 1)
            ++counts[x]
            counts[k] = x
            return counts
        }

        fun update(value: Int): IntArray {
            val x = value % k
            val counts = IntArray(k + 1)
            ++counts[x]
            counts[k] = x
            return counts
        }

        fun query(x: IntArray, y: IntArray): IntArray {
            if (x.isEmpty()) {
                return y
            }
            if (y.isEmpty()) {
                return x
            }
            val counts = x.copyOf()
            for (i in 0 until k) {
                counts[x[k] * i % k] += y[i]
            }
            counts[k] = x[k] * y[k] % k
            return counts
        }

        val segmentTree = SegmentTree(nums.size, ::build, ::update, ::query)
        val result = IntArray(queries.size)
        for (idx in queries.indices) {
            val i = queries[idx][0]
            val value = queries[idx][1]
            val start = queries[idx][2]
            val x = queries[idx][3]
            segmentTree.update(i, value)
            result[idx] = segmentTree.query(start, nums.size - 1)[x]
        }
        return result
    }
}
