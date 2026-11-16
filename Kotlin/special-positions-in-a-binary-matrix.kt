package specialpositionsinabinarymatrix

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        val rows = IntArray(mat.size)
        val cols = IntArray(mat[0].size)
        for (i in rows.indices) {
            for (j in cols.indices) {
                if (mat[i][j] != 0) {
                    ++rows[i]
                    ++cols[j]
                }
            }
        }
        var result = 0
        for (i in rows.indices) {
            for (j in cols.indices) {
                if (mat[i][j] != 0 && rows[i] == 1 && cols[j] == 1) {
                    ++result
                }
            }
        }
        return result
    }
}
