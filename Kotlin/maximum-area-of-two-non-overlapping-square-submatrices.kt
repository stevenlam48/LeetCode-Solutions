package maximumareaoftwononoverlappingsquaresubmatrices

// Time:  O(m * n)
// Space: O(n + min(m, n))

class Solution {
    fun maxArea(mat: Array<IntArray>): Int {
        val inf = Int.MAX_VALUE
        val l = minOf(mat.size, mat[0].size)
        val minR = IntArray(l) { inf }
        val maxR = IntArray(l) { -1 }
        val minC = IntArray(l) { inf }
        val maxC = IntArray(l) { -1 }
        var dp = IntArray(mat[0].size)
        for (r in mat.indices) {
            val newDp = IntArray(mat[0].size)
            for (c in mat[0].indices) {
                if (mat[r][c] == 0) {
                    continue
                }
                newDp[c] = minOf(
                    if (c - 1 >= 0) dp[c - 1] else 0,
                    if (c - 1 >= 0) newDp[c - 1] else 0,
                    dp[c]
                ) + 1
                minR[newDp[c] - 1] = minOf(minR[newDp[c] - 1], r)
                maxR[newDp[c] - 1] = maxOf(maxR[newDp[c] - 1], r)
                minC[newDp[c] - 1] = minOf(minC[newDp[c] - 1], c)
                maxC[newDp[c] - 1] = maxOf(maxC[newDp[c] - 1], c)
            }
            dp = newDp
        }
        for (i in l - 1 downTo 0) {
            if (maxR[i] - minR[i] >= i + 1 || maxC[i] - minC[i] >= i + 1) {
                return (i + 1) * (i + 1)
            }
        }
        return 0
    }
}
