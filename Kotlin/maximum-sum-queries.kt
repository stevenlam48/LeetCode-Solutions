package maximumsumqueries
// Time:  O(nlogn + mlogm + mlogn)
// Space: O(n + m)

class Solution {
    fun maximumSumQueries(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
        val pairs = nums1.indices
            .map { nums1[it] to nums2[it] }
            .sortedWith(compareBy({ it.first }, { it.second }))
        val sortedQueries = queries.indices
            .map { Triple(queries[it][0], queries[it][1], it) }
            .sortedWith(
                compareByDescending<Triple<Int, Int, Int>> { it.first }
                    .thenByDescending { it.second }
                    .thenByDescending { it.third }
            )
        val result = IntArray(queries.size)
        val stk = mutableListOf<Pair<Int, Int>>()
        var p = pairs.size - 1
        for ((x, y, i) in sortedQueries) {
            while (p >= 0 && pairs[p].first >= x) {
                val (a, b) = pairs[p]
                --p
                while (stk.isNotEmpty() && stk.last().second <= a + b) {
                    stk.removeAt(stk.size - 1)
                }
                if (stk.isEmpty() || stk.last().first < b) {
                    stk.add(b to a + b)
                }
            }
            var lo = 0
            var hi = stk.size
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (stk[mid].first < y) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            result[i] = if (lo < stk.size) stk[lo].second else -1
        }
        return result
    }
}
