package maximumconsistentcolumnsinagrid

// Time:  O(m * nlogn + m * n^2 / 64 + n^2 / 64 + n^2) = O(m * n^2 / 64)
// Space: O(n^2 / 64)

class Solution {
    fun maxConsistentColumns(grid: Array<IntArray>, limit: Int): Int {
        val n = grid[0].size
        val lookup = Array(n) { BooleanArray(250) { true } }
        for (row in grid) {
            val idxs = IntArray(n) { it }.sortedWith(compareBy { row[it] })
            val arr = IntArray(n) { row[idxs[it]] }
            val prefix = Array(n + 1) { BooleanArray(250) }
            for (j in 0 until n) {
                prefix[j + 1] = prefix[j].copyOf()
                prefix[j + 1][idxs[j]] = true
            }
            for (j in 0 until n) {
                val upper = upperBound(arr, row[j] + limit)
                val lower = lowerBound(arr, row[j] - limit)
                for (k in 0 until 250) {
                    lookup[j][k] = lookup[j][k] && (prefix[upper][k] xor prefix[lower][k])
                }
            }
        }
        val dp = IntArray(n)
        for (j in 0 until n) {
            var mx = 0
            for (k in 0 until j) {
                if (lookup[j][k]) {
                    mx = maxOf(mx, dp[k])
                }
            }
            dp[j] = mx + 1
        }
        return dp.max()
    }

    private fun lowerBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    private fun upperBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
