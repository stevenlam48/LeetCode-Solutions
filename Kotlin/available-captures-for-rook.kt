package availablecapturesforrook

// Time:  O(1)
// Space: O(1)

class Solution {
    fun numRookCaptures(board: Array<CharArray>): Int {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

        var r = -1
        var c = -1
        var i = 0
        while (i < 8 && r == -1) {
            for (j in 0 until 8) {
                if (board[i][j] == 'R') {
                    r = i
                    c = j
                    break
                }
            }
            ++i
        }

        var result = 0
        for (d in directions) {
            var nr = r + d[0]
            var nc = c + d[1]
            while (0 <= nr && nr < 8 && 0 <= nc && nc < 8) {
                if (board[nr][nc] == 'p') {
                    ++result
                }
                if (board[nr][nc] != '.') {
                    break
                }
                nr += d[0]
                nc += d[1]
            }
        }
        return result
    }
}
