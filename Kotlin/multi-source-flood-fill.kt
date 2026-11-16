package multisourcefloodfill

// Time:  O(n * m)
// Space: O(n * m)

class Solution {
    fun colorGrid(n: Int, m: Int, sources: Array<IntArray>): Array<IntArray> {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        val result = Array(n) { IntArray(m) }
        var q = mutableListOf<IntArray>()
        for (x in sources) {
            val r = x[0]
            val c = x[1]
            val color = x[2]
            result[r][c] = color
            q.add(intArrayOf(r, c))
        }
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<IntArray>()
            for (cell in q) {
                val r = cell[0]
                val c = cell[1]
                for (dir in directions) {
                    val nr = r + dir[0]
                    val nc = c + dir[1]
                    if (!(0 <= nr && nr < n && 0 <= nc && nc < m)) {
                        continue
                    }
                    if (result[nr][nc] == 0) {
                        result[nr][nc] = -result[r][c]
                        newQ.add(intArrayOf(nr, nc))
                    } else if (result[nr][nc] < 0) {
                        result[nr][nc] = minOf(result[nr][nc], -result[r][c])
                    }
                }
            }
            for (cell in newQ) {
                result[cell[0]][cell[1]] = -result[cell[0]][cell[1]]
            }
            q = newQ
        }
        return result
    }
}
