package transformtochessboard
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun movesToChessboard(board: Array<IntArray>): Int {
        val n = board.size
        val rowLookup = HashMap<List<Int>, Int>()
        val colLookup = HashMap<List<Int>, Int>()
        for (i in 0 until n) {
            rowLookup[board[i].toList()] = rowLookup.getOrDefault(board[i].toList(), 0) + 1
            if (rowLookup.size > 2) {
                return -1
            }
        }
        for (j in 0 until n) {
            val col = ArrayList<Int>(n)
            for (i in 0 until n) {
                col.add(board[i][j])
            }
            colLookup[col] = colLookup.getOrDefault(col, 0) + 1
            if (colLookup.size > 2) {
                return -1
            }
        }
        val rowCount = move(n, rowLookup)
        if (rowCount < 0) {
            return -1
        }
        val colCount = move(n, colLookup)
        if (colCount < 0) {
            return -1
        }
        return rowCount + colCount
    }

    private fun move(n: Int, lookup: Map<List<Int>, Int>): Int {
        val counts = lookup.values
        if (lookup.size != 2 || counts.min() != n / 2 || counts.max() != (n + 1) / 2) {
            return -1
        }
        val sequences = lookup.keys.toList()
        val seq1 = sequences[0]
        val seq2 = sequences[1]
        for (i in 0 until n) {
            if (seq1[i] == seq2[i]) {
                return -1
            }
        }
        val begins = if (n % 2 != 0) {
            intArrayOf(if (seq1.count { it == 1 } * 2 > n) 1 else 0)
        } else {
            intArrayOf(0, 1)
        }
        var result = Int.MAX_VALUE
        for (begin in begins) {
            var i = begin
            var sum = 0
            for (v in seq1) {
                sum += if (i % 2 != v) 1 else 0
                ++i
            }
            result = minOf(result, sum / 2)
        }
        return result
    }
}
