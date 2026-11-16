package rangesumquery2dmutable
// Time:  ctor:   O(m * n)
//        update: O(logm * logn)
//        query:  O(logm * logn)
// Space: O(m * n)
class NumMatrix(private val matrix: Array<IntArray>) {
    private val bit: Array<IntArray>

    init {
        if (matrix.isEmpty()) {
            bit = emptyArray()
        } else {
            bit = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
            for (i in 1 until bit.size) {
                for (j in 1 until bit[0].size) {
                    bit[i][j] = matrix[i - 1][j - 1] + bit[i - 1][j] +
                        bit[i][j - 1] - bit[i - 1][j - 1]
                }
            }
            for (i in bit.size - 1 downTo 1) {
                for (j in bit[0].size - 1 downTo 1) {
                    val lastI = i - lowerBit(i)
                    val lastJ = j - lowerBit(j)
                    bit[i][j] = bit[i][j] - bit[i][lastJ] -
                        bit[lastI][j] + bit[lastI][lastJ]
                }
            }
        }
    }

    fun update(row: Int, col: Int, `val`: Int) {
        if (`val` - matrix[row][col] != 0) {
            add(row, col, `val` - matrix[row][col])
            matrix[row][col] = `val`
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sum(row2, col2) - sum(row2, col1 - 1) -
            sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1)
    }

    private fun sum(row: Int, col: Int): Int {
        var i = row + 1
        var j: Int
        var result = 0
        while (i > 0) {
            j = col + 1
            while (j > 0) {
                result += bit[i][j]
                j -= lowerBit(j)
            }
            i -= lowerBit(i)
        }
        return result
    }

    private fun add(row: Int, col: Int, `val`: Int) {
        var i = row + 1
        while (i <= matrix.size) {
            var j = col + 1
            while (j <= matrix[0].size) {
                bit[i][j] += `val`
                j += lowerBit(j)
            }
            i += lowerBit(i)
        }
    }

    private fun lowerBit(i: Int): Int = i and -i
}
