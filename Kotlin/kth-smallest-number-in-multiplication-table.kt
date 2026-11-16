package kthsmallestnumberinmultiplicationtable

// Time:  O(m * log(m * n))
// Space: O(1)

class Solution {
    fun findKthNumber(m: Int, n: Int, k: Int): Int {
        var left = 1
        var right = m * n
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (count(mid, m, n) >= k) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun count(target: Int, m: Int, n: Int): Int {
        var count = 0
        for (i in 1..m) {
            count += minOf(target / i, n)
        }
        return count
    }
}
