package sparsematrixmultiplication

// Time:  O(m * n * l), A is m x n matrix, B is n x l matrix
// Space: O(m * l)

class Solution {
    fun multiply(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val m = A.size
        val n = A[0].size
        val l = B[0].size
        val res = Array(m) { IntArray(l) }
        for (i in 0 until m) {
            for (k in 0 until n) {
                if (A[i][k] != 0) {
                    for (j in 0 until l) {
                        res[i][j] += A[i][k] * B[k][j]
                    }
                }
            }
        }
        return res
    }
}
