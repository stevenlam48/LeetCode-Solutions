package minimumoperationstomakearotatedpalindromei

// Time:  O(nlogn)
// Space: O(n)

// ntt, convolution
private const val MOD = 998244353
private const val G = 3

private fun powmod(a0: Int, b0: Int): Long {
    var a = a0 % MOD
    var b = b0
    var result = 1L
    while (b != 0) {
        if ((b and 1) == 1) {
            result = result * a % MOD
        }
        a = (a.toLong() * a % MOD).toInt()
        b = b shr 1
    }
    return result
}

private fun ntt(a: IntArray, invert: Boolean) {
    val n = a.size
    var j = 0
    for (i in 1 until n) {
        var bit = n shr 1
        while ((j and bit) != 0) {
            j = j xor bit
            bit = bit shr 1
        }
        j = j xor bit
        if (i < j) {
            val tmp = a[i]
            a[i] = a[j]
            a[j] = tmp
        }
    }

    var length = 2
    while (length <= n) {
        var wlen = powmod(G, (MOD - 1) / length)
        if (invert) {
            wlen = powmod(wlen.toInt(), MOD - 2)
        }
        val half = length shr 1
        var i = 0
        while (i < n) {
            var w = 1L
            for (jj in 0 until half) {
                val u = a[i + jj]
                val v = (a[i + jj + half].toLong() * w % MOD).toInt()
                var x = u + v
                if (x >= MOD) {
                    x -= MOD
                }
                var y = u - v
                if (y < 0) {
                    y += MOD
                }
                a[i + jj] = x
                a[i + jj + half] = y
                w = w * wlen % MOD
            }
            i += length
        }
        length = length shl 1
    }
    if (invert) {
        val invN = powmod(n, MOD - 2)
        for (i in 0 until n) {
            a[i] = (a[i].toLong() * invN % MOD).toInt()
        }
    }
}

class Solution {
    fun minOperations(s: String): Int {
        val n = s.length
        var sz = 1
        while (sz < 2 * n - 1) {
            sz = sz shl 1
        }
        val cost = IntArray(n)
        for (k in 0 until 13) {
            val a = IntArray(sz)
            var cnt = 0
            for (i in 0 until n) {
                val d = (((s[i] - 'a') - k) + 26) % 26
                if (d >= 13) {
                    continue
                }
                a[i] = 1
                ++cnt
            }
            ntt(a, false)
            for (i in a.indices) {
                a[i] = (a[i].toLong() * a[i] % MOD).toInt()
            }
            ntt(a, true)
            for (c in 0 until n) {
                cost[c] += cnt - (a[c] + (if (c + n < a.size) a[c + n] else 0))
            }
        }
        var result = Int.MAX_VALUE
        for (i in 0 until n) {
            result = minOf(result, i + cost[(2 * i - 1 + n) % n])
        }
        return result
    }
}
