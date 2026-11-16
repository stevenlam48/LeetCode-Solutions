package twosumlessthank

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun twoSumLessThanK(A: IntArray, K: Int): Int {
        A.sort()
        var result = -1
        var left = 0
        var right = A.size - 1
        while (left < right) {
            if (A[left] + A[right] >= K) {
                --right
            } else {
                result = maxOf(result, A[left] + A[right])
                ++left
            }
        }
        return result
    }
}
