package pourwater
// Time:  O(v * n)
// Space: O(1)

class Solution {
    fun pourWater(heights: IntArray, V: Int, K: Int): IntArray {
        var remaining = V
        while (remaining > 0) {
            var best = K
            for (d in intArrayOf(-1, 1)) {
                var i = K
                while (i + d >= 0 && i + d < heights.size && heights[i + d] <= heights[i]) {
                    if (heights[i + d] < heights[i]) {
                        best = i + d
                    }
                    i += d
                }
                if (best != K) {
                    break
                }
            }
            ++heights[best]
            --remaining
        }
        return heights
    }
}
