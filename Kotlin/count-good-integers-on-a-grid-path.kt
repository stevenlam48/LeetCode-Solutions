package countgoodintegersonagridpath

// Time:  O(16 * 2 * 10 * 10)
// Space: O(16 + 2 * 10)

class Solution {
    fun countGoodIntegersOnPath(l: Long, r: Long, directions: String): Long {
        val length = 16
        val lookup = BooleanArray(length)

        fun count(value: Long): Long {
            var n = value
            val digits = IntArray(length)
            for (i in length - 1 downTo 0) {
                digits[i] = (n % 10).toInt()
                n /= 10
            }
            val dp = Array(2) { LongArray(10) }
            dp[1][0] = 1
            for (i in 0 until length) {
                val newDp = Array(2) { LongArray(10) }
                for (t in 0 until 2) {
                    val bound = if (t == 1) digits[i] else 9
                    for (k in 0 until 10) {
                        if (dp[t][k] == 0L) {
                            continue
                        }
                        for (d in 0..bound) {
                            var nk = k
                            if (lookup[i]) {
                                if (d < k) {
                                    continue
                                }
                                nk = d
                            }
                            newDp[if (t == 1 && d == bound) 1 else 0][nk] += dp[t][k]
                        }
                    }
                }
                for (t in 0 until 2) {
                    dp[t] = newDp[t]
                }
            }
            return dp.sumOf { row -> row.sum() }
        }

        var i = 0
        var j = 0
        lookup[i * 4 + j] = true
        for (x in directions) {
            if (x == 'D') {
                ++i
            } else {
                ++j
            }
            lookup[i * 4 + j] = true
        }
        return count(r) - count(l - 1)
    }
}
