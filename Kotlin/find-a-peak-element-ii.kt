package findapeakelementii

// Time:  O(min(n, m) * log(max(n, m)))
// Space: O(1)

class Solution {
    fun findPeakGrid(mat: Array<IntArray>): IntArray {
        var left = 0
        var right = maxOf(mat.size, mat[0].size) - 1 - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mat, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        val result = intArrayOf(left, findMax(mat, left).first)
        if (!(mat.size > mat[0].size)) {
            result.reverse()
        }
        return result
    }

    private fun check(mat: Array<IntArray>, x: Int): Boolean {
        return findMax(mat, x).second > findMax(mat, x + 1).second
    }

    private fun findMax(mat: Array<IntArray>, x: Int): Pair<Int, Int> {
        var result = Pair(-1, -1)
        for (j in 0 until minOf(mat.size, mat[0].size)) {
            if (result.first == -1 || result.second < getVal(mat, x, j)) {
                result = Pair(j, getVal(mat, x, j))
            }
        }
        return result
    }

    private fun getVal(mat: Array<IntArray>, i: Int, j: Int): Int {
        return if (mat.size > mat[0].size) mat[i][j] else mat[j][i]
    }
}
