package fixedpoint

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun fixedPoint(A: IntArray): Int {
        var left = 0
        var right = A.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (A[mid] >= mid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left < A.size && A[left] == left) left else -1
    }
}
