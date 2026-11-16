package kthsmallestelementinasortedmatrix

// Time:  O(k * log(min(n, m, k))), with n x m matrix
// Space: O(min(n, m, k))

import java.util.PriorityQueue

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        var kthSmallest = 0
        var remaining = k
        val q = PriorityQueue<Triple<Int, Int, Int>>(
            compareBy({ it.first }, { it.second }, { it.third })
        )
        fun push(i: Int, j: Int) {
            if (matrix.size > matrix[0].size) {
                if (i < matrix[0].size && j < matrix.size) {
                    q.add(Triple(matrix[j][i], i, j))
                }
            } else if (i < matrix.size && j < matrix[0].size) {
                q.add(Triple(matrix[i][j], i, j))
            }
        }
        push(0, 0)
        while (q.isNotEmpty() && remaining-- > 0) {
            val tmp = q.remove()
            kthSmallest = tmp.first
            val i = tmp.second
            val j = tmp.third
            push(i, j + 1)
            if (j == 0) {
                push(i + 1, 0)
            }
        }
        return kthSmallest
    }
}
