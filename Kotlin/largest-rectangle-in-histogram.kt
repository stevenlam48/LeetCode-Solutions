package largestrectangleinhistogram

// Time:  O(n)
// Space: O(n)

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stk = ArrayDeque<Int>()
        stk.addLast(-1)
        var result = 0
        for (i in 0..heights.size) {
            while (stk.last() != -1 && (i == heights.size || heights[stk.last()] >= heights[i])) {
                val last = stk.removeLast()
                result = maxOf(result, heights[last] * ((i - 1) - stk.last()))
            }
            stk.addLast(i)
        }
        return result
    }
}
