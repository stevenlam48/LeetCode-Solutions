package cellswithoddvaluesinamatrix

// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val row = IntArray(n)
        val col = IntArray(m)
        for (idx in indices) {
            row[idx[0]] = row[idx[0]] xor 1
            col[idx[1]] = col[idx[1]] xor 1
        }
        val rowSum = row.sum()
        val colSum = col.sum()
        return rowSum * m + colSum * n - 2 * rowSum * colSum
    }
}
