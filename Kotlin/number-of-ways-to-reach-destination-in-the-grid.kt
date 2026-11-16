package numberofwaystoreachdestinationinthegrid

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun numberOfWays(n: Int, m: Int, k: Int, source: IntArray, dest: IntArray): Int {
        var dp = IntArray(4)
        if (source.contentEquals(dest)) {
            dp[0] = 1
        } else if (source[0] == dest[0]) {
            dp[1] = 1
        } else if (source[1] == dest[1]) {
            dp[2] = 1
        } else {
            dp[3] = 1
        }
        val t = arrayOf(
            intArrayOf(0, m - 1, n - 1, 0),
            intArrayOf(1, m - 2, 0, n - 1),
            intArrayOf(1, 0, n - 2, m - 1),
            intArrayOf(0, 1, 1, n - 2 + m - 2)
        )
        dp = matrixMult(arrayOf(dp), matrixExpo(t, k.toLong()))[0]
        return dp[0]
    }

    private fun matrixExpo(a: Array<IntArray>, exponent: Long): Array<IntArray> {
        var pow = exponent
        val result = Array(a.size) { IntArray(a.size) }
        var aExp = Array(a.size) { a[it].clone() }
        for (i in a.indices) {
            result[i][i] = 1
        }
        while (pow != 0L) {
            if (pow % 2L == 1L) {
                val multiplied = matrixMult(result, aExp)
                for (i in result.indices) {
                    result[i] = multiplied[i]
                }
            }
            aExp = matrixMult(aExp, aExp)
            pow /= 2L
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
