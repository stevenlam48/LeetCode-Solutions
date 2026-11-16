package theknightstour

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun tourOfKnight(m: Int, n: Int, r: Int, c: Int): Array<IntArray> {
        val directions = arrayOf(
            intArrayOf(1, 2), intArrayOf(-1, 2), intArrayOf(1, -2), intArrayOf(-1, -2),
            intArrayOf(2, 1), intArrayOf(-2, 1), intArrayOf(2, -1), intArrayOf(-2, -1)
        )
        val result = Array(m) { IntArray(n) { -1 } }
        result[r][c] = 0

        fun degree(x: IntArray): Int {
            var cnt = 0
            for (d in directions) {
                val nr = x[0] + d[0]
                val nc = x[1] + d[1]
                if (nr in 0 until m && nc in 0 until n && result[nr][nc] == -1) {
                    ++cnt
                }
            }
            return cnt
        }

        fun backtracking(r: Int, c: Int, i: Int): Boolean {
            if (i == m * n) {
                return true
            }
            val candidates = ArrayList<IntArray>()
            for (d in directions) {
                val nr = r + d[0]
                val nc = c + d[1]
                if (nr in 0 until m && nc in 0 until n && result[nr][nc] == -1) {
                    candidates.add(intArrayOf(nr, nc))
                }
            }
            candidates.sortWith(compareBy { degree(it) })
            for (p in candidates) {
                result[p[0]][p[1]] = i
                if (backtracking(p[0], p[1], i + 1)) {
                    return true
                }
                result[p[0]][p[1]] = -1
            }
            return false
        }

        backtracking(r, c, 1)
        return result
    }
}
