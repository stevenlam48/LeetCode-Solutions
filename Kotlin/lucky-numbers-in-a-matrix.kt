package luckynumbersinamatrix

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val rows = mutableListOf<Int>()
        for (row in matrix) {
            rows.add(row.minOrNull()!!)
        }
        val cols = mutableListOf<Int>()
        for (c in matrix[0].indices) {
            var maxCell = 0
            for (r in matrix.indices) {
                maxCell = maxOf(maxCell, matrix[r][c])
            }
            cols.add(maxCell)
        }
        val result = mutableListOf<Int>()
        for (r in matrix.indices) {
            for (c in matrix[0].indices) {
                if (rows[r] == cols[c]) {
                    result.add(matrix[r][c])
                }
            }
        }
        return result
    }
}
