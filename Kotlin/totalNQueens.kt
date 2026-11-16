package totalNQueens

// Time Complexity: O(n!)
// Space Complexity: O(n)

class Solution {
    private var ans = 0
    private lateinit var cols: IntArray
    private lateinit var mainDiag: IntArray
    private lateinit var antiDiag: IntArray
    private lateinit var chess: IntArray

    private fun dfs(row: Int) {
        val n = chess.size
        if (row == n) {
            ++ans
            return
        }

        for (i in 0 until n) {
            if (cols[i] == 0 && mainDiag[row + i] == 0 && antiDiag[row - i + n] == 0) {
                cols[i] = 1
                mainDiag[row + i] = 1
                antiDiag[row - i + n] = 1
                chess[row] = i
                dfs(row + 1)
                cols[i] = 0
                mainDiag[row + i] = 0
                antiDiag[row - i + n] = 0
            }
        }
    }

    fun totalNQueens(n: Int): Int {
        ans = 0
        cols = IntArray(n)
        mainDiag = IntArray(2 * n)
        antiDiag = IntArray(2 * n)
        chess = IntArray(n)

        dfs(0)

        return ans
    }
}
