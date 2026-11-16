package findthecountofgoodintegers

import kotlin.math.pow

// Time:  O(n + 10 * 10^((n + 1)/2))
// Space: O(n + 10 * (10 * nHr(10, n/2)))
class Solution {
    fun countGoodIntegers(n: Int, k: Int): Long {
        val l = (n + 1) / 2
        val fact = IntArray(n + 1) { 1 }
        for (i in 0 until fact.lastIndex) {
            fact[i + 1] = fact[i] * (i + 1)
        }
        var result = 0L
        val lookup = hashSetOf<List<Int>>()
        val upperBound = 10.0.pow(l).toInt()
        for (d in 10.0.pow(l - 1).toInt() until upperBound) {
            val x = palindrome(d, n)
            if (x % k != 0L) {
                continue
            }
            val cnt = count(x)
            if (!lookup.add(cnt.toList())) {
                continue
            }
            var total = (n - cnt[0]).toLong() * fact[n - 1]
            for (c in cnt) {
                total /= fact[c]
            }
            result += total
        }
        return result
    }

    private fun reverse(x0: Int, n: Int): Int {
        var x = x0
        if (n % 2 != 0) {
            x /= 10
        }
        var result = 0
        while (x != 0) {
            result = result * 10 + x % 10
            x /= 10
        }
        return result
    }

    private fun palindrome(x: Int, n: Int): Long {
        return x * 10.0.pow(n / 2).toLong() + reverse(x, n)
    }

    private fun count(x0: Long): IntArray {
        var x = x0
        val cnt = IntArray(10)
        while (x != 0L) {
            ++cnt[(x % 10).toInt()]
            x /= 10
        }
        return cnt
    }
}
