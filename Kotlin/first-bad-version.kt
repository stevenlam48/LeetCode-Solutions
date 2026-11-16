package firstbadversion

// Time:  O(logn)
// Space: O(1)

class Solution(private val isBadVersion: (Int) -> Boolean = { false }) {
    fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (isBadVersion(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
