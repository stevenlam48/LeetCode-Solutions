package maximumsumoftwononoverlappingsubarrays
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSumTwoNoOverlap(A: IntArray, L: Int, M: Int): Int {
        for (i in 1 until A.size) {
            A[i] += A[i - 1]
        }
        var result = A[L + M - 1]
        var lMax = A[L - 1]
        var mMax = A[M - 1]
        for (i in L + M until A.size) {
            lMax = maxOf(lMax, A[i - M] - A[i - L - M])
            mMax = maxOf(mMax, A[i - L] - A[i - L - M])
            result = maxOf(
                result,
                maxOf(lMax + A[i] - A[i - M], mMax + A[i] - A[i - L])
            )
        }
        return result
    }
}
