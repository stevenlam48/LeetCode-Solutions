package monotonicarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun isMonotonic(A: IntArray): Boolean {
        var inc = false
        var dec = false
        for (i in 0 until A.size - 1) {
            if (A[i] < A[i + 1]) {
                inc = true
            } else if (A[i] > A[i + 1]) {
                dec = true
            }
        }
        return !inc || !dec
    }
}
