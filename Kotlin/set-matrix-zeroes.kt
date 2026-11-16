package setmatrixzeroes

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        if (matrix.isEmpty()) {
            return
        }
        var hasZero = false
        var zeroI = -1
        var zeroJ = -1
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    if (!hasZero) {
                        zeroI = i
                        zeroJ = j
                        hasZero = true
                    }
                    matrix[zeroI][j] = 0
                    matrix[i][zeroJ] = 0
                }
            }
        }
        if (hasZero) {
            for (i in matrix.indices) {
                if (i == zeroI) {
                    continue
                }
                for (j in matrix[0].indices) {
                    if (j == zeroJ) {
                        continue
                    }
                    if (matrix[zeroI][j] == 0 || matrix[i][zeroJ] == 0) {
                        matrix[i][j] = 0
                    }
                }
            }
            for (i in matrix.indices) {
                matrix[i][zeroJ] = 0
            }
            for (j in matrix[0].indices) {
                matrix[zeroI][j] = 0
            }
        }
    }
}
