package longestincreasingsubsequenceii

// Time:  O(nlogn)
// Space: O(n)

// segment tree with coordinate compression
class Solution {
    fun lengthOfLIS(nums: IntArray, k: Int): Int {
        val numsSet = HashSet<Int>()
        for (x in nums) {
            numsSet.add(x - 1)
        }
        val sortedNums = numsSet.sorted()
        val numToIdx = HashMap<Int, Int>()
        for (i in sortedNums.indices) {
            numToIdx[sortedNums[i]] = i
        }
        val st = SegmentTree(numToIdx.size)
        for (x0 in nums) {
            val x = x0 - 1
            val i = lowerBound(sortedNums, x - k)
            val idx = numToIdx[x]!!
            st.update(idx, st.query(i, idx - 1) + 1)
        }
        return st.tree[1]
    }

    private fun lowerBound(a: List<Int>, target: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    private class SegmentTree(N: Int) {
        val tree: IntArray
        private val base: Int

        init {
            if (N > 1) {
                val h = Integer.highestOneBit(N - 1)
                tree = IntArray(h shl 2)
                base = h shl 1
            } else {
                tree = IntArray(2)
                base = 1
            }
        }

        fun update(i: Int, h: Int) {
            var x = base + i
            tree[x] = h
            while (x > 1) {
                x /= 2
                tree[x] = maxOf(tree[x * 2], tree[x * 2 + 1])
            }
        }

        fun query(L0: Int, R0: Int): Int {
            if (L0 > R0) {
                return 0
            }
            var L = L0 + base
            var R = R0 + base
            var result = 0
            while (L <= R) {
                if (L and 1 == 1) {
                    result = maxOf(result, tree[L])
                    ++L
                }
                if (R and 1 == 0) {
                    result = maxOf(tree[R], result)
                    --R
                }
                L /= 2
                R /= 2
            }
            return result
        }
    }
}
