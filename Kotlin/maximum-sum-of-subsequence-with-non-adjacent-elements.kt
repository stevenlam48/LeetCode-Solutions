package maximumsumofsubsequencewithnonadjacentelements
// Time:  O(n + qlogn)
// Space: O(n)

class Solution {
    fun maximumSumSubsequence(nums: IntArray, queries: Array<IntArray>): Int {
        val MOD = 1_000_000_007
        val n = nums.size
        val base = if (n > 1) Integer.highestOneBit(n - 1) shl 1 else 1
        val tree = Array(if (n > 1) base shl 1 else 2) { LongArray(0) }

        fun merge(x: LongArray, y: LongArray): LongArray {
            if (x.isEmpty()) {
                return y
            }
            if (y.isEmpty()) {
                return x
            }
            return longArrayOf(
                maxOf(x[2] + y[1], x[0] + y[1], x[2] + y[0]),
                maxOf(x[3] + y[1], x[1] + y[1], x[3] + y[0]),
                maxOf(x[2] + y[3], x[0] + y[3], x[2] + y[2]),
                maxOf(x[3] + y[3], x[1] + y[3], x[3] + y[2])
            )
        }

        fun build(i: Int): LongArray {
            return longArrayOf(maxOf(nums[i], 0).toLong(), 0L, 0L, 0L)
        }

        for (i in base until base + n) {
            tree[i] = build(i - base)
        }
        for (i in base - 1 downTo 1) {
            tree[i] = merge(tree[i shl 1], tree[(i shl 1) + 1])
        }

        fun update(i: Int, h: LongArray) {
            var x = base + i
            tree[x] = h
            while (x > 1) {
                x = x shr 1
                tree[x] = merge(tree[x shl 1], tree[(x shl 1) + 1])
            }
        }

        var result = 0
        for (q in queries) {
            update(q[0], longArrayOf(maxOf(q[1], 0).toLong(), 0L, 0L, 0L))
            result = ((result + tree[1].max()) % MOD).toInt()
        }
        return result
    }
}
