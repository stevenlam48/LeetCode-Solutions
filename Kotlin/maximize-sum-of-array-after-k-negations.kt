package maximizesumofarrayafterknegations

// Time:  O(n) ~ O(n^2), O(n) on average.
// Space: O(1)

class Solution {
    fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
        A.sort()
        var remain = K
        for (i in 0 until K) {
            if (A[i] < 0) {
                A[i] = -A[i]
                --remain
            }
        }
        return A.sum() - (remain % 2) * A.minOrNull()!! * 2
    }
}
