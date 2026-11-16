package minimumnonzeroproductofthearrayelements

// Time:  O(min(p, logM))
// Space: O(1)

class Solution {
    fun minNonZeroProduct(p: Int): Int {
        val mod = 1_000_000_007L
        val maxNumMod = submod(powmod(2L, p.toLong(), mod), 1L, mod)
        val pairProductMod = submod(maxNumMod, 1L, mod)
        val pairCountModM1 = submod(powmod(2L, (p - 1).toLong(), mod - 1L), 1L, mod - 1L)
        return mulmod(
            maxNumMod,
            powmod(pairProductMod, pairCountModM1, mod),
            mod
        ).toInt()
    }

    private fun addmod(a: Long, b: Long, mod: Long): Long {
        var addend = b
        if (mod - a <= addend) {
            addend -= mod
        }
        return a + addend
    }

    private fun submod(a: Long, b: Long, mod: Long): Long {
        return addmod(a, mod - b, mod)
    }

    private fun mulmod(a: Long, b: Long, mod: Long): Long {
        var result = 0L
        var multiplicand = a
        var multiplier = b
        if (multiplicand < multiplier) {
            val temp = multiplicand
            multiplicand = multiplier
            multiplier = temp
        }
        while (multiplier > 0L) {
            if (multiplier % 2L == 1L) {
                result = addmod(result, multiplicand, mod)
            }
            multiplicand = addmod(multiplicand, multiplicand, mod)
            multiplier /= 2L
        }
        return result
    }

    private fun powmod(a: Long, b: Long, mod: Long): Long {
        var base = a % mod
        var exponent = b
        var result = 1L
        while (exponent != 0L) {
            if ((exponent and 1L) != 0L) {
                result = mulmod(result, base, mod)
            }
            base = mulmod(base, base, mod)
            exponent = exponent shr 1
        }
        return result
    }
}
