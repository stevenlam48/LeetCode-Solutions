package cuttingribbons

// Time:  O(nlogr), r is sum(ribbons)/k
// Space: O(1)

class Solution {
    fun maxLength(ribbons: IntArray, k: Int): Int {
        var left = 1L
        var right = ribbons.fold(0L) { total, x -> total + x } / k
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(ribbons, k, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right.toInt()
    }

    private fun check(ribbons: IntArray, k: Int, s: Long): Boolean {
        return ribbons.fold(0L) { total, x -> total + x / s } >= k
    }
}
