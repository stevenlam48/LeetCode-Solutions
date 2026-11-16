package findminimumtimetofinishalljobs

// Time:  O(k^n * logr), the real complexity should be much less, but hard to analyze
// Space: O(n + k)

class Solution {
    fun minimumTimeRequired(jobs: IntArray, k: Int): Int {
        val sorted = jobs.sortedDescending().toIntArray()
        var left = sorted.max()
        var right = sorted.sum()
        while (left <= right) {
            val mid = left + (right - left) / 2
            val counts = IntArray(k)
            if (backtracking(sorted, 0, mid, counts)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun backtracking(jobs: IntArray, i: Int, cap: Int, counts: IntArray): Boolean {
        if (i == jobs.size) {
            return true
        }
        for (j in counts.indices) {
            if (counts[j] + jobs[i] <= cap) {
                counts[j] += jobs[i]
                if (backtracking(jobs, i + 1, cap, counts)) {
                    return true
                }
                counts[j] -= jobs[i]
            }
            if (counts[j] == 0) {
                break
            }
        }
        return false
    }
}
