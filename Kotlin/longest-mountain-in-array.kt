package longestmountaininarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestMountain(A: IntArray): Int {
        var result = 0
        var upLen = 0
        var downLen = 0
        for (i in 1 until A.size) {
            if ((downLen != 0 && A[i - 1] < A[i]) || A[i - 1] == A[i]) {
                upLen = 0
                downLen = 0
            }
            if (A[i - 1] < A[i]) {
                ++upLen
            }
            if (A[i - 1] > A[i]) {
                ++downLen
            }
            if (upLen != 0 && downLen != 0) {
                result = maxOf(result, upLen + downLen + 1)
            }
        }
        return result
    }
}
