package countnumberofwaystoplacehouses

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countHousePlacements(n: Int): Int {
        val t = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
        val result = matrixMult(arrayOf(intArrayOf(2, 1)), matrixExpo(t, n - 1))[0][0].toLong()
        return (result * result % mod).toInt()
    }

    private fun matrixExpo(a: Array<IntArray>, pow: Int): Array<IntArray> {
        var result = Array(a.size) { IntArray(a.size) }
        var aExp = a.map { it.clone() }.toTypedArray()
        for (i in a.indices) {
            result[i][i] = 1
        }
        var exponent = pow
        while (exponent != 0) {
            if (exponent % 2 == 1) {
                result = matrixMult(result, aExp)
            }
            aExp = matrixMult(aExp, aExp)
            exponent /= 2
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

    private val mod = 1_000_000_007L
}
