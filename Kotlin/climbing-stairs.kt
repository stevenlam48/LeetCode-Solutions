package climbingstairs

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun climbStairs(n: Int): Int {
        val t = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
        return matrixMult(arrayOf(intArrayOf(1, 0)), matrixExpo(t, n))[0][0]
    }

    private fun matrixExpo(a: Array<IntArray>, pow: Int): Array<IntArray> {
        var result = Array(a.size) { IntArray(a.size) }
        var aExp = a.map { it.clone() }.toTypedArray()
        var power = pow
        for (i in a.indices) {
            result[i][i] = 1
        }
        while (power != 0) {
            if (power % 2 == 1) {
                result = matrixMult(result, aExp)
            }
            aExp = matrixMult(aExp, aExp)
            power /= 2
        }
        return result
    }

    private fun matrixMult(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val result = Array(a.size) { IntArray(b[0].size) }
        for (i in a.indices) {
            for (j in b[0].indices) {
                var entry = 0L
                for (k in b.indices) {
                    entry = a[i][k].toLong() * b[k][j] + entry
                }
                result[i][j] = entry.toInt()
            }
        }
        return result
    }
}
