package zigzaggridtraversalwithskip

// Time:  O(n * m)
// Space: O(1)

// array
class Solution {
    fun zigzagTraversal(grid: Array<IntArray>): IntArray {
        val result = ArrayList<Int>()
        for (i in grid.indices) {
            if (i % 2 == 0) {
                var j = 0
                while (j < grid[0].size) {
                    result.add(grid[i][j])
                    j += 2
                }
            } else {
                var j = (grid[0].size - 1) - grid[0].size % 2
                while (j >= 0) {
                    result.add(grid[i][j])
                    j -= 2
                }
            }
        }
        return result.toIntArray()
    }
}
