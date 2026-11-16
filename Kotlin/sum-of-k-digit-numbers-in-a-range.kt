package sumofkdigitnumbersinarange

// Time:  O(logr), r = MOD
// Space: O(1)

// math
class Solution {
    fun sumOfNumbers(l: Int, r: Int, k: Int): Int {
        val MOD = 1_000_000_007

        fun addmod(a: Int, b0: Int, mod: Int): Int {  // avoid overflow
            var b = b0
            if (mod - a <= b) {
                b -= mod
            }
            return a + b
        }

        fun submod(a: Int, b: Int, mod: Int): Int = addmod(a, mod - b, mod)

        fun mulmod(a0: Int, b0: Int, mod: Int): Int {  // avoid overflow
            var a = a0
            var b = b0
            if (a < b) {
                val t = a
                a = b
                b = t
            }
            var result = 0
            while (b > 0) {
                if (b % 2 == 1) {
                    result = addmod(result, a, mod)
                }
                a = addmod(a, a, mod)
                b /= 2
            }
            return result
        }

        fun powmod(a0: Int, b0: Int, mod: Int): Int {
            var a = a0 % mod
            var b = b0
            var result = 1
            while (b != 0) {
                if (b and 1 == 1) {
                    result = mulmod(result, a, mod)
                }
                a = mulmod(a, a, mod)
                b = b shr 1
            }
            return result
        }

        fun invmod(x: Int, mod: Int): Int = powmod(x, mod - 2, mod)

        val triangleSum = ((l.toLong() + r) * (r - l + 1) / 2 % MOD).toInt()
        return mulmod(
            mulmod(triangleSum, powmod(r - l + 1, k - 1, MOD), MOD),
            mulmod(submod(powmod(10, k, MOD), 1, MOD), invmod(10 - 1, MOD), MOD),
            MOD
        )
    }
}
