package longestincreasingpathinamatrix

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val directions = arrayOf(0 to -1, 0 to 1, -1 to 0, 1 to 0)
        if (matrix.isEmpty()) {
            return 0
        }
        val inDegree = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                for ((di, dj) in directions) {
                    val ni = i + di
                    val nj = j + dj
                    if (!(ni >= 0 && ni < matrix.size && nj >= 0 && nj < matrix[0].size && matrix[ni][nj] > matrix[i][j])) {
                        continue
                    }
                    ++inDegree[i][j]
                }
            }
        }
        var q = mutableListOf<Pair<Int, Int>>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (inDegree[i][j] == 0) {
                    q.add(i to j)
                }
            }
        }
        var result = 0
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Pair<Int, Int>>()
            for ((i, j) in q) {
                for ((di, dj) in directions) {
                    val ni = i + di
                    val nj = j + dj
                    if (!(ni >= 0 && ni < matrix.size && nj >= 0 && nj < matrix[0].size && matrix[i][j] > matrix[ni][nj])) {
                        continue
                    }
                    if (--inDegree[ni][nj] == 0) {
                        newQ.add(ni to nj)
                    }
                }
            }
            q = newQ
            ++result
        }
        return result
    }
}
