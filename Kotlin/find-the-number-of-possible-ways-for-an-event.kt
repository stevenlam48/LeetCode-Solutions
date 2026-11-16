package findthenumberofpossiblewaysforanevent

// Time:  precompute: O(max_n^2 + max_y * min(max_n, max_x))
//        runtime:    O(min(n, x))
// Space: O(max_n^2 + max_y * min(max_n, max_x))

private const val MOD = 1_000_000_007
private const val MAX_N = 1000
private const val MAX_X = 1000
private const val MAX_Y = 1000
private val R = minOf(MAX_N, MAX_X)
private val NCR = Array(MAX_N + 1) { IntArray(MAX_N + 1) }
private val DP = Array(MAX_N + 1) { IntArray(MAX_N + 1) }
private val POW = Array(MAX_Y + 1) { IntArray(R + 1) { 1 } }

private fun init() {
    if (NCR[0][0] != 0) {
        return
    }
    NCR[0][0] = 1
    DP[0][0] = 1
    for (i in 1..MAX_N) {
        NCR[i][0] = 1
        for (j in 1L..i.toLong()) {
            val column = j.toInt()
            NCR[i][column] = (NCR[i - 1][column] + NCR[i - 1][column - 1]) % MOD
            DP[i][column] = ((DP[i - 1][column] * j + DP[i - 1][column - 1] * j) % MOD).toInt()
        }
    }
    for (i in 1L..MAX_Y.toLong()) {
        for (j in 1..R) {
            POW[i.toInt()][j] = (POW[i.toInt()][j - 1] * i % MOD).toInt()
        }
    }
}

class Solution {
    fun numberOfWays(n: Int, x: Int, y: Int): Int {
        init()
        var result = 0
        for (i in 1..minOf(n, x)) {
            val term = NCR[x][i].toLong() * DP[n][i] % MOD * POW[y][i] % MOD
            result = (result + term.toInt()) % MOD
        }
        return result
    }
}
