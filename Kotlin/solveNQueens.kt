package solveNQueens

// Time Complexity: O(n!)
// Space Complexity: O(n)

class Solution {
    private val ans = ArrayList<List<String>>()
    private lateinit var cols: IntArray
    private lateinit var mainDiag: IntArray
    private lateinit var antiDiag: IntArray
    private lateinit var chess: IntArray

    fun solveNQueens(n: Int): List<List<String>> {
        cols = IntArray(n)
        mainDiag = IntArray(2 * n)
        antiDiag = IntArray(2 * n)
        chess = IntArray(n)

        dfs(0)

        return ans
    }

    private fun addAnswer(n: Int) {
        val v = ArrayList<String>()
        for (i in 0 until n) {
            val s = CharArray(n) { '.' }
            s[chess[i]] = 'Q'
            v.add(String(s))
        }
        ans.add(v)
    }

    private fun dfs(row: Int) {
        val n = chess.size
        if (row == n) {
            addAnswer(n)
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
}
