package heightchecker

// Time:  O(nlogn)
// Space: O(n)
class Solution {
    fun heightChecker(heights: IntArray): Int {
        val sortedHeights = heights.copyOf()
        sortedHeights.sort()
        var result = 0
        for (i in heights.indices) {
            if (heights[i] != sortedHeights[i]) {
                ++result
            }
        }
        return result
    }
}
