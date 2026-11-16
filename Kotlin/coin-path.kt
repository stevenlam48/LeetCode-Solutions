package coinpath

// Time:  O(n * B)
// Space: O(n)


class Solution {
    fun cheapestJump(A: IntArray, B: Int): IntArray {
        if (A.isEmpty() || A.last() == -1) {
            return IntArray(0)
        }
        val n = A.size
        val dp = IntArray(n) { Int.MAX_VALUE }
        val next = IntArray(n) { -1 }
        dp[n - 1] = A[n - 1]
        for (i in n - 2 downTo 0) {
            if (A[i] == -1) {
                continue
            }
            for (j in i + 1..minOf(i + B, n - 1)) {
                if (dp[j] == Int.MAX_VALUE) {
                    continue
                }
                if (A[i] + dp[j] < dp[i]) {
                    dp[i] = A[i] + dp[j]
                    next[i] = j
                }
            }
        }
        if (dp[0] == Int.MAX_VALUE) {
            return IntArray(0)
        }
        val result = ArrayList<Int>()
        var k = 0
        while (k != -1) {
            result.add(k + 1)
            k = next[k]
        }
        return result.toIntArray()
    }
}
