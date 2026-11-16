package checkifwordcanbeplacedincrossword

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun placeWordInCrossword(board: Array<CharArray>, word: String): Boolean {
        var w = word
        for (d in 0 until 2) {
            w = w.reversed()
            for (transposed in 0 until 2) {
                for (i in 0 until getR(board, transposed == 1)) {
                    var it = 0
                    var matched = true
                    for (j in 0 until getC(board, transposed == 1)) {
                        val c = getVal(board, i, j, transposed == 1)
                        if (c == '#') {
                            if (it == w.length && matched) {
                                return true
                            }
                            it = 0
                            matched = true
                            continue
                        }
                        if (!matched) {
                            continue
                        }
                        matched = it != w.length && (c == w[it] || c == ' ')
                        if (it != w.length && (c == w[it] || c == ' ')) {
                            ++it
                        }
                    }
                    if (it == w.length && matched) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun getR(mat: Array<CharArray>, transposed: Boolean): Int {
        return if (!transposed) mat.size else mat[0].size
    }

    private fun getC(mat: Array<CharArray>, transposed: Boolean): Int {
        return if (!transposed) mat[0].size else mat.size
    }

    private fun getVal(mat: Array<CharArray>, i: Int, j: Int, transposed: Boolean): Char {
        return if (!transposed) mat[i][j] else mat[j][i]
    }
}
