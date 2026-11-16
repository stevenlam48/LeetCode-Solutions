package largestsubmatrixwithrearrangements

// Time:  O(m * nlogn)
// Space: O(1)

class Solution {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        for (c in matrix[0].indices) {
            var h = 0
            for (r in matrix.indices) {
                h = if (matrix[r][c] == 1) h + 1 else 0
                matrix[r][c] = h
            }
        }
        var result = 0
        for (row in matrix) {
            row.sort()
            for (c in row.indices) {
                result = maxOf(result, (row.size - c) * row[c])
            }
        }
        return result
    }
}
