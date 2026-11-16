package maximumscoreusingexactlykpairs

// Time:  O(n * m * k)
// Space: O(min(n, m) * k)

class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val negInf = Long.MIN_VALUE
        var a = nums1
        var b = nums2
        if (a.size < b.size) {
            val t = a
            a = b
            b = t
        }
        var dp = Array(b.size + 1) { LongArray(k + 1) { negInf } }
        for (j in dp.indices) {
            dp[j][0] = 0L
        }
        var newDp = Array(b.size + 1) { LongArray(k + 1) { negInf } }
        for (i in a.indices) {
            for (j in newDp.indices) {
                newDp[j][0] = 0L
            }
            for (j in b.indices) {
                val score = a[i].toLong() * b[j]
                val mx = minOf(i + 1, j + 1, k)
                for (c in 0 until mx) {
                    newDp[j + 1][c + 1] = maxOf(
                        newDp[j][c + 1],
                        dp[j + 1][c + 1],
                        dp[j][c] + score
                    )
                }
            }
            val t = dp
            dp = newDp
            newDp = t
        }
        return dp.last().last()
    }
}
