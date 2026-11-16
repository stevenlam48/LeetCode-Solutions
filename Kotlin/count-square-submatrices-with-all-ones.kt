package countsquaresubmatriceswithallones

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    continue
                }
                val l = minOf(matrix[i - 1][j], matrix[i][j - 1])
                matrix[i][j] = if (matrix[i - l][j - l] != 0) l + 1 else l
            }
        }
        var result = 0
        for (row in matrix) {
            for (x in row) {
                result += x
            }
        }
        return result
    }
}
