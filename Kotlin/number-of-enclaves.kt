package numberofenclaves

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun numEnclaves(A: Array<IntArray>): Int {
        val m = A.size
        val n = A[0].size
        for (i in 0 until m) {
            dfs(A, i, 0)
            dfs(A, i, n - 1)
        }
        for (j in 1 until n - 1) {
            dfs(A, 0, j)
            dfs(A, m - 1, j)
        }
        var result = 0
        for (row in A) {
            for (v in row) {
                result += v
            }
        }
        return result
    }

    private fun dfs(A: Array<IntArray>, i: Int, j: Int) {
        if (!(0 <= i && i < A.size &&
              0 <= j && j < A[0].size &&
              A[i][j] != 0)) {
            return
        }
        A[i][j] = 0
        dfs(A, i, j + 1)
        dfs(A, i + 1, j)
        dfs(A, i, j - 1)
        dfs(A, i - 1, j)
    }
}
