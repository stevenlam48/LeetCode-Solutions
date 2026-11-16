package minimumtimetakestoreachdestinationwithoutdrowning

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun minimumSeconds(land: Array<Array<String>>): Int {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
        val m = land.size
        val n = land[0].size
        val lookup = Array(m) { IntArray(n) }
        var q = mutableListOf<IntArray>()
        var i0 = -1
        var j0 = -1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (land[i][j] == "*") {
                    q.add(intArrayOf(i, j, -1))
                    lookup[i][j] = -1
                } else if (land[i][j] == "S") {
                    i0 = i
                    j0 = j
                }
            }
        }
        q.add(intArrayOf(i0, j0, 1))
        lookup[i0][j0] = 1
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<IntArray>()
            for (cur in q) {
                val i = cur[0]
                val j = cur[1]
                val d = cur[2]
                if (land[i][j] == "D") {
                    return d - 1
                }
                for (dir in directions) {
                    val ni = i + dir[0]
                    val nj = j + dir[1]
                    if (!(0 <= ni && ni < m && 0 <= nj && nj < n && land[ni][nj] != "X" && lookup[ni][nj] != -1)) {
                        continue
                    }
                    if (d != -1 && lookup[ni][nj] == 0) {
                        lookup[ni][nj] = 1
                        newQ.add(intArrayOf(ni, nj, d + 1))
                    } else if (d == -1 && land[ni][nj] != "D") {
                        lookup[ni][nj] = -1
                        newQ.add(intArrayOf(ni, nj, -1))
                    }
                }
            }
            q = newQ
        }
        return -1
    }
}
