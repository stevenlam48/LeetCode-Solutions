package maxsumofsubmatrixnolargerthank

// Time:  O(min(m, n)^2 * max(m, n) * log(max(m, n)))
// Space: O(max(m, n))

import java.util.TreeSet

class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        if (matrix.isEmpty()) {
            return 0
        }

        val m = minOf(matrix.size, matrix[0].size)
        val n = maxOf(matrix.size, matrix[0].size)
        var result = Int.MIN_VALUE
        for (i in 0 until m) {
            val sums = IntArray(n)
            for (j in i until m) {
                for (l in 0 until n) {
                    sums[l] += if (m == matrix.size) matrix[j][l] else matrix[l][j]
                }
                val accuSumSet = TreeSet<Int>()
                accuSumSet.add(0)
                var accuSum = 0
                for (sum in sums) {
                    accuSum += sum
                    val previous = accuSumSet.ceiling(accuSum - k)
                    if (previous != null) {
                        result = maxOf(result, accuSum - previous)
                    }
                    accuSumSet.add(accuSum)
                }
            }
        }
        return result
    }
}
