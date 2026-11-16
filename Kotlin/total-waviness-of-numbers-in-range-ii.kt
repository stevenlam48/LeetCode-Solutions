package totalwavinessofnumbersinrangeii

// Time:  O(logn * 11 * 11 * 2 * 2 * 10)
// Space: O(logn * 11 * 11 * 2 * 2)

class Solution {
    fun totalWaviness(num1: Long, num2: Long): Long {
        fun count(x: Long): Long {
            val s = x.toString()
            val lookup = Array(s.length * 11 * 11 * 2 * 2) { longArrayOf(-1L, -1L) }

            fun encode(i: Int, prev: Int, prev2: Int, zero: Boolean, tight: Boolean): Int {
                var key = i.toLong()
                key = key * 11 + (prev + 1)
                key = key * 11 + (prev2 + 1)
                key = key * 2 + (if (zero) 1 else 0)
                key = key * 2 + (if (tight) 1 else 0)
                return key.toInt()
            }

            fun dp(i: Int, prev: Int, prev2: Int, zero: Boolean, tight: Boolean): LongArray {
                if (i == s.length) {
                    return longArrayOf(1L, 0L)
                }
                val key = encode(i, prev, prev2, zero, tight)
                if (lookup[key][0] == -1L) {
                    var cnt = 0L
                    var w = 0L
                    val mx = if (tight) s[i] - '0' else 9
                    for (d in 0..mx) {
                        val newTight = tight && (d == s[i] - '0')
                        val newZero = zero && (d == 0)
                        val newPrev2 = prev
                        val newPrev = if (!newZero) d else -1
                        val sub = dp(i + 1, newPrev, newPrev2, newZero, newTight)
                        cnt += sub[0]
                        if (!zero && prev2 != -1 &&
                            ((prev2 < prev && prev > d) || (prev2 > prev && prev < d))
                        ) {
                            w += sub[0]
                        }
                        w += sub[1]
                    }
                    lookup[key] = longArrayOf(cnt, w)
                }
                return lookup[key]
            }

            return dp(0, -1, -1, true, true)[1]
        }

        return count(num2) - count(num1 - 1)
    }
}
