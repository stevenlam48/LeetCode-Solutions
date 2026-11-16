package minimumnumberofflipstoconvertbinarymatrixtozeromatrix

// Time:  O((m * n) * 2^(m * n))
// Space: O((m * n) * 2^(m * n))

import java.util.ArrayDeque

class Solution {
    fun minFlips(mat: Array<IntArray>): Int {
        var start = 0
        for (r in mat.indices) {
            for (c in mat[0].indices) {
                start = start or (mat[r][c] shl (r * mat[0].size + c))
            }
        }
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(start to 0)
        val lookup = mutableSetOf(start)
        while (q.isNotEmpty()) {
            val (state, step) = q.removeFirst()
            if (state == 0) {
                return step
            }
            for (r in mat.indices) {
                for (c in mat[0].indices) {
                    var newState = state
                    for ((dr, dc) in DIRECTIONS) {
                        val nr = r + dr
                        val nc = c + dc
                        if (nr >= 0 && nr < mat.size && nc >= 0 && nc < mat[0].size) {
                            newState = newState xor (1 shl (nr * mat[0].size + nc))
                        }
                    }
                    if (lookup.contains(newState)) {
                        continue
                    }
                    lookup.add(newState)
                    q.add(newState to step + 1)
                }
            }
        }
        return -1
    }

    companion object {
        private val DIRECTIONS = arrayOf(0 to 0, 0 to 1, 1 to 0, 0 to -1, -1 to 0)
    }
}
