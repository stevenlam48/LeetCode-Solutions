package doublemodularexponentiation

// Time:  O(n * (logb + logc))
// Space: O(1)

// fast exponentiation
class Solution {
    fun getGoodIndices(variables: Array<IntArray>, target: Int): IntArray {
        fun addmod(a0: Long, b0: Long, mod: Long): Long {
            var a = a0 % mod
            var b = b0 % mod
            if (mod - a <= b) {
                b -= mod
            }
            return a + b
        }

        fun mulmod(a0: Long, b0: Long, mod: Long): Long {
            var a = a0 % mod
            var b = b0 % mod
            var result = 0L
            if (a < b) {
                val t = a
                a = b
                b = t
            }
            while (b > 0) {
                if (b % 2 == 1L) {
                    result = addmod(result, a, mod)
                }
                a = addmod(a, a, mod)
                b /= 2
            }
            return result
        }

        fun powmod(a0: Long, b0: Long, mod: Long): Long {
            var a = a0 % mod
            var b = b0
            var result = 1L
            while (b > 0) {
                if (b and 1L == 1L) {
                    result = mulmod(result, a, mod)
                }
                a = mulmod(a, a, mod)
                b = b shr 1
            }
            return result
        }

        val result = mutableListOf<Int>()
        for (i in variables.indices) {
            if (powmod(powmod(variables[i][0].toLong(), variables[i][1].toLong(), 10L), variables[i][2].toLong(), variables[i][3].toLong()) == target.toLong()) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
