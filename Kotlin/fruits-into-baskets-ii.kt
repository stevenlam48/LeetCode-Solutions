package fruitsintobasketsii

// Time:  O(nlogn)
// Space: O(n)

// segment tree, binary search
class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        var result = 0
        val st = SegmentTree(baskets)
        for (x in fruits) {
            val i = st.binarySearch(x)
            if (i == -1) {
                ++result
            } else {
                st.update(i, 0)
            }
        }
        return result
    }

    private class SegmentTree(nums: IntArray) {
        private val tree: IntArray
        private val base: Int

        init {
            val m = nums.size
            if (m > 1) {
                val lg = 31 - Integer.numberOfLeadingZeros(m - 1)
                base = 1 shl (lg + 1)
                tree = IntArray(1 shl (lg + 2))
            } else {
                base = 1
                tree = IntArray(2)
            }
            for (i in base until tree.size) {
                tree[i] = if (i - base < m) nums[i - base] else 0
            }
            for (i in base - 1 downTo 1) {
                tree[i] = maxOf(tree[2 * i], tree[2 * i + 1])
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

        fun binarySearch(x: Int): Int {
            if (tree[1] < x) {
                return -1
            }
            var i = 1
            while (i < base) {
                i = if (tree[2 * i] >= x) 2 * i else 2 * i + 1
            }
            return i - base
        }
    }
}
