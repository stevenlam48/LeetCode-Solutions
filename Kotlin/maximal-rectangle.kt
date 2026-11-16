package maximalrectangle

// Time:  O(m * n)
// Space: O(n)

// Ascending stack solution.
class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return 0
        }

        var result = 0
        val heights = IntArray(matrix[0].size)
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                heights[j] = if (matrix[i][j] == '1') heights[j] + 1 else 0
            }
            result = maxOf(result, largestRectangleArea(heights))
        }
        return result
    }

    private fun largestRectangleArea(heights: IntArray): Int {
        val stk = ArrayDeque<Int>()
        stk.addLast(-1)
        var res = 0
        for (i in 0..heights.size) {
            while (stk.last() != -1 && (i == heights.size || heights[stk.last()] >= heights[i])) {
                val last = stk.removeLast()
                res = maxOf(res, heights[last] * ((i - 1) - stk.last()))
            }
            stk.addLast(i)
        }
        return res
    }
}
