package pizzawith3nslices
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun maxSizeSlices(slices: IntArray): Int {
        return maxOf(
            maxSizeSlicesLinear(slices, 0, slices.size - 1),
            maxSizeSlicesLinear(slices, 1, slices.size)
        )
    }

    private fun maxSizeSlicesLinear(slices: IntArray, start: Int, end: Int): Int {
        val dp = Array(2) { IntArray(slices.size / 3 + 1) }
        for (i in start until end) {
            for (j in minOf(((i - start + 1) - 1) / 2 + 1, slices.size / 3) downTo 1) {
                dp[i % 2][j] = maxOf(
                    dp[(i - 1 + 2) % 2][j],
                    dp[(i - 2 + 2) % 2][j - 1] + slices[i]
                )
            }
        }
        return dp[(end - 1) % 2][slices.size / 3]
    }
}
