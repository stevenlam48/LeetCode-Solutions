package minimumrelativelossafterbuyingchocolates

// Time:  O((n + q) * logn)
// Space: O(n)

class Solution {
    fun minimumRelativeLosses(prices: IntArray, queries: Array<IntArray>): LongArray {
        fun binarySearch(left: Int, right: Int, check: (Int) -> Boolean): Int {
            var l = left
            var r = right
            while (l <= r) {
                val mid = l + (r - l) / 2
                if (check(mid)) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
            return l
        }

        prices.sort()
        val n = prices.size
        val prefix = LongArray(n + 1)
        for (i in 0 until n) {
            prefix[i + 1] = prefix[i] + prices[i]
        }
        val result = LongArray(queries.size)
        for (i in queries.indices) {
            val k = queries[i][0]
            val m = queries[i][1]
            val cnt = binarySearch(0, m - 1) { x ->
                k - (prices[n - (m - x)] - k) <= prices[(x + 1) - 1]
            }
            val a = prefix[n] - prefix[n - (m - cnt)] - (m - cnt).toLong() * k
            val b = prefix[cnt] + (m - cnt).toLong() * k
            result[i] = b - a
        }
        return result
    }
}
