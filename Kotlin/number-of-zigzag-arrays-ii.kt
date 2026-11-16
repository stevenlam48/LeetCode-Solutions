package numberofzigzagarraysii

// Time:  O((r - l)^3 * logn)
// Space: O((r - l)^2)

class Solution {
    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val size = r - l
        val matrix = Array(size + 1) { IntArray(size + 1) }
        for (i in 0..size) {
            for (j in 0..size - 1 - i) {
                matrix[i][j] = 1
            }
        }
        val matrixPow = matrixExpo(matrix, (n - 1).toLong())
        val result = matrixMult(arrayOf(IntArray(size + 1) { 1 }), matrixPow)
        var sum = 0
        for (x in result[0]) {
            sum = (sum + x) % mod
        }
        return sum * 2 % mod
    }

    private fun matrixExpo(a: Array<IntArray>, exponent: Long): Array<IntArray> {
        var pow = exponent
        val result = Array(a.size) { IntArray(a.size) }
        var aExp = Array(a.size) { a[it].clone() }
        for (i in a.indices) {
            result[i][i] = 1
        }
        while (pow != 0L) {
            if (pow and 1L == 1L) {
                val multiplied = matrixMult(result, aExp)
                for (i in result.indices) {
                    result[i] = multiplied[i]
                }
            }
            aExp = matrixMult(aExp, aExp)
            pow = pow shr 1
        }
        return result
    }

    private fun matrixMult(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val result = Array(a.size) { IntArray(b[0].size) }
        for (i in a.indices) {
            for (j in b[0].indices) {
                var entry = 0L
                for (k in b.indices) {
                    entry = (a[i][k].toLong() * b[k][j] % mod + entry) % mod
                }
                result[i][j] = entry.toInt()
            }
        }
        return result
    }

    private val mod = 1_000_000_007
}
