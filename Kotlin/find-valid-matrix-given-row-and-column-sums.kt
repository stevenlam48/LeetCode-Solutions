package findvalidmatrixgivenrowandcolumnsums
// Time:  O(m + n), excluding ctor of result
// Space: O(1)

class Solution {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val matrix = Array(rowSum.size) { IntArray(colSum.size) }
        var i = 0
        var j = 0
        while (i < matrix.size && j < matrix[0].size) {
            matrix[i][j] = minOf(rowSum[i], colSum[j])
            rowSum[i] -= matrix[i][j]
            colSum[j] -= matrix[i][j]
            if (rowSum[i] == 0) {
                ++i
            }
            if (colSum[j] == 0) {
                ++j
            }
        }
        return matrix
    }
}
