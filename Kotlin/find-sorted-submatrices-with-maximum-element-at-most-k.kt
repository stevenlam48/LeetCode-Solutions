package findsortedsubmatriceswithmaximumelementatmostk

// Time:  O(m * n)
// Space: O(m)

// mono stack
class Solution {
    fun countSubmatrices(grid: Array<IntArray>, k: Int): Long {
        fun count(heights: IntArray): Int {
            var result = 0
            val stk = mutableListOf<Int>()
            var curr = 0
            for (i in heights.indices) {
                while (stk.isNotEmpty() && heights[stk.last()] >= heights[i]) {
                    val j = stk.removeAt(stk.size - 1)
                    curr -= (heights[j] - heights[i]) * (j - (if (stk.isNotEmpty()) stk.last() else -1))
                }
                stk.add(i)
                curr += heights[i]
                result += curr
            }
            return result
        }

        var result = 0L
        val heights = IntArray(grid.size)
        for (j in grid[0].size - 1 downTo 0) {
            for (i in grid.indices) {
                if (grid[i][j] > k) {
                    heights[i] = 0
                } else if (j + 1 < grid[0].size && grid[i][j] >= grid[i][j + 1]) {
                    ++heights[i]
                } else {
                    heights[i] = 1
                }
            }
            result += count(heights)
        }
        return result
    }
}
