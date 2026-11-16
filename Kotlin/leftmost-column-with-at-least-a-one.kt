package leftmostcolumnwithatleastaone
// Time:  O(m + n)
// Space: O(1)

open class BinaryMatrix(private val matrix: Array<IntArray>) {
    open fun get(row: Int, column: Int): Int = matrix[row][column]

    open fun dimensions(): IntArray = intArrayOf(matrix.size, matrix.firstOrNull()?.size ?: 0)
}

class Solution {
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val dim = binaryMatrix.dimensions()
        val m = dim[0]
        val n = dim[1]
        var r = 0
        var c = n - 1
        while (r < m && c >= 0) {
            if (binaryMatrix.get(r, c) == 0) {
                ++r
            } else {
                --c
            }
        }
        return if (c + 1 != n) c + 1 else -1
    }
}
