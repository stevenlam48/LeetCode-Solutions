package numberofwaystopaintn3grid

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun numOfWays(n: Int): Int {
        val t = arrayOf(intArrayOf(3, 2), intArrayOf(2, 2))
        val result = matrixMult(arrayOf(intArrayOf(6, 6)), matrixExpo(t, n - 1))[0]
        return (result[0] + result[1]) % mod
    }

    private fun matrixExpo(a: Array<IntArray>, exponent: Int): Array<IntArray> {
        var pow = exponent
        val result = Array(a.size) { IntArray(a.size) }
        var aExp = Array(a.size) { a[it].clone() }
        for (i in a.indices) {
            result[i][i] = 1
        }
        while (pow != 0) {
            if (pow % 2 == 1) {
                val multiplied = matrixMult(result, aExp)
                for (i in result.indices) {
                    result[i] = multiplied[i]
                }
            }
            aExp = matrixMult(aExp, aExp)
            pow /= 2
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
