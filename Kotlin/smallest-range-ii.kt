package smallestrangeii
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun smallestRangeII(A: IntArray, K: Int): Int {
        A.sort()
        var result = A.last() - A.first()
        for (i in 0 until A.size - 1) {
            result = minOf(
                result,
                maxOf(A.last() - K, A[i] + K) - minOf(A.first() + K, A[i + 1] - K)
            )
        }
        return result
    }
}
