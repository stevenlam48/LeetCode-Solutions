package findwinneronatictactoegame
// Time:  O(1)
// Space: O(1)

class Solution {
    fun tictactoe(moves: Array<IntArray>): String {
        val row = Array(2) { IntArray(3) }
        val col = Array(2) { IntArray(3) }
        val diag = IntArray(2)
        val antiDiag = IntArray(2)
        var p = 0
        for (move in moves) {
            val r = move[0]
            val c = move[1]
            ++row[p][r]
            ++col[p][c]
            diag[p] += if (r == c) 1 else 0
            antiDiag[p] += if (r + c == 2) 1 else 0
            if (intArrayOf(row[p][r], col[p][c], diag[p], antiDiag[p]).contains(3)) {
                return "AB"[p].toString()
            }
            p = p xor 1
        }
        return if (moves.size == 9) "Draw" else "Pending"
    }
}
