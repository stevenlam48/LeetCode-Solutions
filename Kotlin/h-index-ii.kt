package hindexii

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun hIndex(citations: IntArray): Int {
        val n = citations.size
        var left = 0
        var right = n - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (citations[mid] >= n - mid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return n - left
    }
}
