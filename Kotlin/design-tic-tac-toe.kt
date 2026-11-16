package designtictactoe

// Time:  O(1), per move.
// Space: O(n^2)

class TicTacToe(n: Int) {
    private val rows = Array(n) { IntArray(2) }
    private val cols = Array(n) { IntArray(2) }
    private val diagonal = IntArray(2)
    private val antiDiagonal = IntArray(2)

    fun move(row: Int, col: Int, player: Int): Int {
        val i = player - 1
        ++rows[row][i]
        ++cols[col][i]
        if (row == col) {
            ++diagonal[i]
        }
        if (col == rows.size - row - 1) {
            ++antiDiagonal[i]
        }
        if (rows[row][i] == rows.size ||
            cols[col][i] == cols.size ||
            diagonal[i] == rows.size ||
            antiDiagonal[i] == cols.size
        ) {
            return player
        }
        return 0
    }
}
