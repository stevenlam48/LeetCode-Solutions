package imageoverlap

// Time:  O(n^4)
// Space: O(n^2)

class Solution {
    fun largestOverlap(A: Array<IntArray>, B: Array<IntArray>): Int {
        val count = IntArray((2 * A.size - 1) * (2 * A.size - 1))
        for (i in A.indices) {
            for (j in A[i].indices) {
                if (A[i][j] == 0) {
                    continue
                }
                for (m in B.indices) {
                    for (n in B[m].indices) {
                        if (B[m][n] == 0) {
                            continue
                        }
                        ++count[(A.size - 1 + i - m) * (2 * A.size - 1) +
                            A.size - 1 + j - n]
                    }
                }
            }
        }
        return count.max()
    }
}
