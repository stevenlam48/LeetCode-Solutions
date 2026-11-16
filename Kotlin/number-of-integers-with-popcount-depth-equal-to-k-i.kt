package numberofintegerswithpopcountdepthequaltoki

// Time:  precompute: O((logr)^2), r = max(n)
//        runtime:    O((logn)^2)
// Space: O((logr)^2)

// combinatorics
private fun bitLength(x: Long): Int = if (x != 0L) 64 - java.lang.Long.numberOfLeadingZeros(x) else 0

private const val MAX_N = 1_000_000_000_000_000L
private val MAX_BIT_LEN = bitLength(MAX_N)

private val NCR: Array<LongArray> = Array(MAX_BIT_LEN + 1) { LongArray(MAX_BIT_LEN + 1) }.also { ncr ->
    for (i in ncr.indices) {
        for (j in 0..i) {
            ncr[i][j] = if (0 < j && j < i) ncr[i - 1][j] + ncr[i - 1][j - 1] else 1L
        }
    }
}

private val D: IntArray = IntArray(MAX_BIT_LEN + 1).also { d ->
    for (i in 2 until d.size) {
        d[i] = d[Integer.bitCount(i)] + 1
    }
}

class Solution {
    fun popcountDepth(n: Long, k: Int): Long {
        if (k == 0) {
            return 1
        }
        val l = bitLength(n)
        if (k == 1) {
            return (l - 1).toLong()
        }
        fun count(c: Int): Long {
            var result = 0L
            var cnt = 0
            for (i in l - 1 downTo 0) {
                if ((n and (1L shl i)) == 0L) {
                    continue
                }
                if (0 <= c - cnt && c - cnt <= i) {
                    result += NCR[i][c - cnt]
                }
                ++cnt
            }
            if (cnt == c) {
                ++result
            }
            return result
        }

        var result = 0L
        for (c in 2..l) {
            if (D[c] == k - 1) {
                result += count(c)
            }
        }
        return result
    }
}
