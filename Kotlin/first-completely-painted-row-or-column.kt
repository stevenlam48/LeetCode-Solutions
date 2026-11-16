package firstcompletelypaintedroworcolumn

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val lookup = HashMap<Int, IntArray>()
        for (i in mat.indices) {
            for (j in mat[0].indices) {
                lookup[mat[i][j]] = intArrayOf(i, j)
            }
        }
        val row = IntArray(mat.size)
        val col = IntArray(mat[0].size)
        for (idx in arr.indices) {
            val (i, j) = lookup[arr[idx]]!!
            ++row[i]
            ++col[j]
            if (row[i] == mat[0].size || col[j] == mat.size) {
                return idx
            }
        }
        return -1
    }
}
