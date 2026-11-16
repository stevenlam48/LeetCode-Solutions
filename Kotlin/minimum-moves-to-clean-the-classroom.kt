package minimummovestocleantheclassroom

// Time:  O(m * n * 2^l)
// Space: O(m * n * 2^l)

class Solution {
    fun minMoves(classroom: Array<String>, energy: Int): Int {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        val m = classroom.size
        val n = classroom[0].length
        val lookup = HashMap<Int, Int>()
        var r = -1
        var c = -1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (classroom[i][j] == 'S') {
                    r = i
                    c = j
                } else if (classroom[i][j] == 'L') {
                    lookup[i * n + j] = lookup.size
                }
            }
        }

        val lookup2 = Array(m) { Array(n) { IntArray(1 shl lookup.size) { -1 } } }
        lookup2[r][c][0] = energy
        var q = ArrayList<IntArray>()
        q.add(intArrayOf(r, c, 0, energy))
        var result = 0
        while (q.isNotEmpty()) {
            val newQ = ArrayList<IntArray>()
            for (state in q) {
                val i = state[0]
                val j = state[1]
                val mask = state[2]
                val e = state[3]
                if (lookup2[i][j][mask] != e) {
                    continue
                }
                if (mask == (1 shl lookup.size) - 1) {
                    return result
                }
                for (dir in directions) {
                    val ni = i + dir[0]
                    val nj = j + dir[1]
                    var ne = e - 1
                    if (!(0 <= ni && ni < m && 0 <= nj && nj < n && classroom[ni][nj] != 'X' && ne >= 0)) {
                        continue
                    }
                    var newMask = mask
                    if (classroom[ni][nj] == 'R') {
                        ne = energy
                    } else if (classroom[ni][nj] == 'L') {
                        newMask = newMask or (1 shl lookup[ni * n + nj]!!)
                    }
                    if (ne <= lookup2[ni][nj][newMask]) {
                        continue
                    }
                    lookup2[ni][nj][newMask] = ne
                    newQ.add(intArrayOf(ni, nj, newMask, ne))
                }
            }
            q = newQ
            ++result
        }
        return -1
    }
}
