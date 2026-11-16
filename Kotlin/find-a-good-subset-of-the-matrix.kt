package findagoodsubsetofthematrix

// Time:  O(m * 2^n)
// Space: O(2^n)

class Solution {
    fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {
        val lookup = HashMap<Int, Int>()
        for (i in grid.indices) {
            var mask = 0
            for (j in grid[0].indices) {
                mask = mask or (grid[i][j] shl j)
            }
            if (mask == 0) {
                return listOf(i)
            }
            for ((mask2, j) in lookup) {
                if (mask2 and mask == 0) {
                    return listOf(j, i)
                }
            }
            lookup[mask] = i
        }
        return emptyList()
    }
}
