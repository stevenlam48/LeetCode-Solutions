package fibonaccinumber

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun fib(N: Int): Int {
        val T = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
        return matrixMult(arrayOf(intArrayOf(1, 0)), matrixExpo(T, N))[0][1]
    }

    private fun matrixExpo(A: Array<IntArray>, pow: Int): Array<IntArray> {
        var result = Array(A.size) { IntArray(A.size) }
        var A_exp = Array(A.size) { A[it].clone() }
        var exponent = pow
        for (i in A.indices) {
            result[i][i] = 1
        }
        while (exponent != 0) {
            if (exponent % 2 == 1) {
                result = matrixMult(result, A_exp)
            }
            A_exp = matrixMult(A_exp, A_exp)
            exponent /= 2
        }
        return result
    }

    private fun matrixMult(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val result = Array(A.size) { IntArray(B[0].size) }
        for (i in A.indices) {
            for (j in B[0].indices) {
                var entry = 0L
                for (k in B.indices) {
                    entry = A[i][k].toLong() * B[k][j] + entry
                }
                result[i][j] = entry.toInt()
            }
        }
        return result
    }
}
