package numberofvisiblepeopleinaqueue

// Time:  O(n)
// Space: O(n)

class Solution {
    fun canSeePersonsCount(heights: IntArray): IntArray {
        val result = IntArray(heights.size)
        val stk = IntArray(heights.size)
        var top = 0
        for (i in heights.indices) {
            while (top > 0 && heights[stk[top - 1]] < heights[i]) {
                ++result[stk[top - 1]]
                --top
            }
            if (top > 0) {
                ++result[stk[top - 1]]
            }
            if (top > 0 && heights[stk[top - 1]] == heights[i]) {
                --top
            }
            stk[top++] = i
        }
        return result
    }
}
