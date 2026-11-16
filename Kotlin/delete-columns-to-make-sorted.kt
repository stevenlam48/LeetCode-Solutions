package deletecolumnstomakesorted

// Time:  O(n * l)
// Space: O(1)
class Solution {
    fun minDeletionSize(A: Array<String>): Int {
        var result = 0
        for (c in A[0].indices) {
            for (r in 1 until A.size) {
                if (A[r - 1][c] > A[r][c]) {
                    ++result
                    break
                }
            }
        }
        return result
    }
}
