package maximumstrictlyincreasingcellsinamatrix

// Time:  O(m * n * log(m * n))
// Space: O(m * n)

class Solution {
    fun maxIncreasingCells(mat: Array<IntArray>): Int {
        val lookup = java.util.TreeMap<Int, MutableList<IntArray>>()
        for (i in mat.indices) {
            for (j in mat[0].indices) {
                lookup.getOrPut(mat[i][j]) { ArrayList() }.add(intArrayOf(i, j))
            }
        }
        val dp = Array(mat.size) { IntArray(mat[0].size) }
        val row = IntArray(mat.size)
        val col = IntArray(mat[0].size)
        for (pairs in lookup.values) {
            for (p in pairs) {
                dp[p[0]][p[1]] = maxOf(row[p[0]], col[p[1]]) + 1
            }
            for (p in pairs) {
                row[p[0]] = maxOf(row[p[0]], dp[p[0]][p[1]])
                col[p[1]] = maxOf(col[p[1]], dp[p[0]][p[1]])
            }
        }
        return row.max()
    }
}
