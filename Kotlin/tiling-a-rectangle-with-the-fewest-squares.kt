package tilingarectanglewiththefewestsquares

// Time:  O(n^2 * m^2 * m^(n * m)), given m < n
// Space: O(n * m)

class Solution {
    fun tilingRectangle(n: Int, m: Int): Int {
        if (m > n) {
            return tilingRectangle(m, n)
        }
        val board = Array(n) { IntArray(m) }
        var result = Int.MAX_VALUE

        fun findNext(): Pair<Int, Int> {
            for (i in board.indices) {
                for (j in board[0].indices) {
                    if (board[i][j] == 0) {
                        return Pair(i, j)
                    }
                }
            }
            return Pair(-1, -1)
        }

        fun findMaxLength(i: Int, j: Int): Int {
            var maxLength = 1
            while (i + maxLength - 1 < board.size && j + maxLength - 1 < board[0].size) {
                for (r in i until i + maxLength - 1) {
                    if (board[r][j + maxLength - 1] != 0) {
                        return maxLength - 1
                    }
                }
                for (c in j until j + maxLength) {
                    if (board[i + maxLength - 1][c] != 0) {
                        return maxLength - 1
                    }
                }
                ++maxLength
            }
            return maxLength - 1
        }

        fun fill(i: Int, j: Int, length: Int, value: Int) {
            for (r in i until i + length) {
                for (c in j until j + length) {
                    board[r][c] = value
                }
            }
        }

        fun backtracking(count: Int) {
            if (count >= result) {
                return
            }
            val (i, j) = findNext()
            if (i == -1 && j == -1) {
                result = minOf(result, count)
                return
            }
            val maxLength = findMaxLength(i, j)
            for (k in maxLength downTo 1) {
                fill(i, j, k, 1)
                backtracking(count + 1)
                fill(i, j, k, 0)
            }
        }

        backtracking(0)
        return result
    }
}
