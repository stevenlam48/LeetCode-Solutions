package maximizenumberofnicedivisors

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun maxNiceDivisors(primeFactors: Int): Int {
        val mod = 1_000_000_007
        if (primeFactors <= 3) {
            return primeFactors
        }
        if (primeFactors % 3 == 0) {
            return powmod(3, primeFactors / 3, mod)
        }
        if (primeFactors % 3 == 1) {
            return (4L * powmod(3, (primeFactors - 4) / 3, mod) % mod).toInt()
        }
        return (2L * powmod(3, (primeFactors - 2) / 3, mod) % mod).toInt()
    }

    private fun powmod(a: Int, exponent: Int, mod: Int): Int {
        var base = (a % mod).toLong()
        var b = exponent
        var result = 1L
        while (b != 0) {
            if (b and 1 != 0) {
                result = result * base % mod
            }
            base = base * base % mod
            b = b shr 1
        }
        return result.toInt()
    }
}
