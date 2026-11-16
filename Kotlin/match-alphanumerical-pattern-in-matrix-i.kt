package matchalphanumericalpatterninmatrixi

// Time:  O(n * m * r * c)
// Space: O(1)

// brute force, hash table
class Solution {
    fun findPattern(board: Array<IntArray>, pattern: List<String>): IntArray {
        fun check(i: Int, j: Int): Boolean {
            val lookup = IntArray(26) { -1 }
            val lookup2 = BooleanArray(10)
            for (r in pattern.indices) {
                for (c in pattern[0].indices) {
                    val y = board[i + r][j + c]
                    if (pattern[r][c].isDigit()) {
                        if (pattern[r][c] - '0' != y) {
                            return false
                        }
                        continue
                    }
                    val x = pattern[r][c] - 'a'
                    if (lookup[x] == -1) {
                        if (lookup2[y]) {
                            return false
                        }
                        lookup2[y] = true
                        lookup[x] = y
                        continue
                    }
                    if (lookup[x] != y) {
                        return false
                    }
                }
            }
            return true
        }

        var i = 0
        while (i + pattern.size - 1 < board.size) {
            var j = 0
            while (j + pattern[0].length - 1 < board[0].size) {
                if (check(i, j)) {
                    return intArrayOf(i, j)
                }
                ++j
            }
            ++i
        }
        return intArrayOf(-1, -1)
    }
}
