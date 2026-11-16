package maximumsegmentsumafterremovals

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumSegmentSum(nums: IntArray, removeQueries: IntArray): LongArray {
        val result = LongArray(nums.size)
        val lookup = BooleanArray(nums.size)
        val uf = UnionFind(nums)
        for (i in removeQueries.size - 1 downTo 1) {
            val q = removeQueries[i]
            lookup[q] = true
            if (q - 1 >= 0 && lookup[q - 1]) {
                uf.unionSet(q - 1, q)
            }
            if (q + 1 < lookup.size && lookup[q + 1]) {
                uf.unionSet(q, q + 1)
            }
            result[i - 1] = maxOf(result[i], uf.total(q))
        }
        return result
    }

    private class UnionFind(nums: IntArray) {
        private val set_ = IntArray(nums.size) { it }
        private val rank_ = IntArray(nums.size)
        private val size_ = LongArray(nums.size) { nums[it].toLong() }

        fun findSet(x: Int): Int {
            if (set_[x] != x) {
                set_[x] = findSet(set_[x])
            }
            return set_[x]
        }

        fun unionSet(x0: Int, y0: Int): Boolean {
            var x = findSet(x0)
            var y = findSet(y0)
            if (x == y) {
                return false
            }
            if (rank_[x] > rank_[y]) {
                val t = x
                x = y
                y = t
            }
            set_[x] = y
            if (rank_[x] == rank_[y]) {
                rank_[y]++
            }
            size_[y] += size_[x]
            return true
        }

        fun total(x: Int): Long = size_[findSet(x)]
    }
}
