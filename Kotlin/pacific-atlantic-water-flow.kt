package pacificatlanticwaterflow
// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun pacificAtlantic(matrix: Array<IntArray>): List<IntArray> {
        if (matrix.isEmpty()) {
            return emptyList()
        }
        val result = mutableListOf<IntArray>()
        val m = matrix.size
        val n = matrix[0].size
        val visited = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            pacificAtlanticHelper(matrix, i, 0, Int.MIN_VALUE, PACIFIC, visited, result)
            pacificAtlanticHelper(matrix, i, n - 1, Int.MIN_VALUE, ATLANTIC, visited, result)
        }
        for (j in 0 until n) {
            pacificAtlanticHelper(matrix, 0, j, Int.MIN_VALUE, PACIFIC, visited, result)
            pacificAtlanticHelper(matrix, m - 1, j, Int.MIN_VALUE, ATLANTIC, visited, result)
        }
        return result
    }

    private fun pacificAtlanticHelper(
        matrix: Array<IntArray>,
        x: Int,
        y: Int,
        previousHeight: Int,
        previousValue: Int,
        visited: Array<IntArray>,
        result: MutableList<IntArray>
    ) {
        if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[0].size ||
            matrix[x][y] < previousHeight || visited[x][y] or previousValue == visited[x][y]
        ) {
            return
        }
        visited[x][y] = visited[x][y] or previousValue
        if (visited[x][y] == (PACIFIC or ATLANTIC)) {
            result.add(intArrayOf(x, y))
        }
        for (direction in DIRECTIONS) {
            pacificAtlanticHelper(
                matrix,
                x + direction[0],
                y + direction[1],
                matrix[x][y],
                visited[x][y],
                visited,
                result
            )
        }
    }

    private companion object {
        const val PACIFIC = 1
        const val ATLANTIC = 2
        val DIRECTIONS = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(1, 0))
    }
}
