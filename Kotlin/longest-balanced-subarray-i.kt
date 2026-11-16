package longestbalancedsubarrayi

// Time:  O(nlogn)
// Space: O(n)

// segment tree, binary search, prefix sum
class Solution {
    fun longestBalanced(nums: IntArray): Int {
        val n = nums.size + 1
        val st = SegmentTree(n)
        var result = 0
        val lookup = HashMap<Int, Int>()
        var curr = 0
        for (i in 1..nums.size) {
            val d = if ((nums[i - 1] and 1) == 1) 1 else -1
            val prev = lookup[nums[i - 1]]
            if (prev != null) {
                st.update(prev, n - 1, -d)
                curr -= d
            }
            curr += d
            lookup[nums[i - 1]] = i
            st.update(i, n - 1, d)
            val l = i - st.binarySearch(curr)
            if (l > result) {
                result = l
            }
        }
        return result
    }

    private class SegmentTree(N: Int) {
        private val base: Int = if (N > 1) 1 shl (lg(N - 1) + 1) else 1
        private val lazy = IntArray(base)
        private val min = IntArray(if (N > 1) 1 shl (lg(N - 1) + 2) else 2)
        private val max = IntArray(if (N > 1) 1 shl (lg(N - 1) + 2) else 2)

        fun update(L0: Int, R0: Int, value: Int) {
            var L = L0 + base
            var R = R0 + base
            val l0 = L
            val r0 = R
            while (L <= R) {
                if ((L and 1) == 1) {
                    apply(L, value)
                    ++L
                }
                if ((R and 1) == 0) {
                    apply(R, value)
                    --R
                }
                L = L shr 1
                R = R shr 1
            }
            pull(l0)
            pull(r0)
        }

        fun binarySearch(x: Int): Int {
            var i = 1
            while (i < base) {
                if (lazy[i] != 0) {
                    apply(i shl 1, lazy[i])
                    apply((i shl 1) or 1, lazy[i])
                    lazy[i] = 0
                }
                i = i shl 1
                if (!(min[i] <= x && x <= max[i])) {
                    i = i or 1
                }
            }
            return i - base
        }

        private fun apply(x: Int, value: Int) {
            min[x] += value
            max[x] += value
            if (x < base) {
                lazy[x] += value
            }
        }

        private fun pull(x0: Int) {
            var x = x0
            while (x > 1) {
                x = x shr 1
                min[x] = minOf(min[x shl 1], min[(x shl 1) or 1])
                max[x] = maxOf(max[x shl 1], max[(x shl 1) or 1])
                if (lazy[x] != 0) {
                    min[x] += lazy[x]
                    max[x] += lazy[x]
                }
            }
        }

        private fun lg(x: Int): Int = 31 - Integer.numberOfLeadingZeros(x)
    }
}
