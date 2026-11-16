package rangesumquery2dimmutable
// Time:  ctor:   O(m * n),
//        lookup: O(1)
// Space: O(m * n)
class NumMatrix(matrix: Array<IntArray>) {
    private val sums: Array<IntArray>

    init {
        if (matrix.isEmpty()) {
            sums = emptyArray()
        } else {
            val m = matrix.size
            val n = matrix[0].size
            sums = Array(m + 1) { IntArray(n + 1) }
            for (i in 1..m) {
                for (j in 1..n) {
                    sums[i][j] = sums[i][j - 1] + sums[i - 1][j] -
                        sums[i - 1][j - 1] + matrix[i - 1][j - 1]
                }
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] -
            sums[row1][col2 + 1] + sums[row1][col1]
    }
}
