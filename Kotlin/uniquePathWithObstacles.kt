package uniquePathWithObstacles

// Time Complexity: O(m * n)
// Space Complexity: O(m + n)

class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val v = IntArray(n)
        v[0] = 1
        for (i in 0 until m) {
            if (obstacleGrid[i][0] != 0) {
                v[0] = 0
            }
            for (j in 1 until n) {
                if (obstacleGrid[i][j] == 0) {
                    v[j] += v[j - 1]
                } else {
                    v[j] = 0
                }
            }
        }
        return v[n - 1]
    }
}
