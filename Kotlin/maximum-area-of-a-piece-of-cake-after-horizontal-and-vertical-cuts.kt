package maximumareaofapieceofcakeafterhorizontalandverticalcuts

// Time:  O(hlogh + wlogw)
// Space: O(1)

class Solution {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        val mod = 1_000_000_007L
        return (maxLen(h, horizontalCuts) * maxLen(w, verticalCuts) % mod).toInt()
    }

    private fun maxLen(l: Int, cuts: IntArray): Long {
        cuts.sort()
        var result = maxOf(cuts[0], l - cuts.last())
        for (i in 1 until cuts.size) {
            result = maxOf(result, cuts[i] - cuts[i - 1])
        }
        return result.toLong()
    }
}
