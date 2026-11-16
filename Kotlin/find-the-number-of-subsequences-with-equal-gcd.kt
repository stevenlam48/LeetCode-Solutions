package findthenumberofsubsequenceswithequalgcd

// Time:  precompute: O(max_r^2 * log(max_r))
//        runtime:    O(n + r^2)
// Space: O(max_r^2)

private const val MOD = 1_000_000_007
private const val MAX_NUM = 200

private fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val temp = x % y
        x = y
        y = temp
    }
    return x
}

private val POW2 = IntArray(MAX_NUM + 1) { 1 }.also { powers ->
    for (i in 0 until powers.lastIndex) {
        powers[i + 1] = (powers[i] * 2L % MOD).toInt()
    }
}

private val POW3 = IntArray(MAX_NUM + 1) { 1 }.also { powers ->
    for (i in 0 until powers.lastIndex) {
        powers[i + 1] = (powers[i] * 3L % MOD).toInt()
    }
}

private val LCM = Array(MAX_NUM + 1) { IntArray(MAX_NUM + 1) }.also { lcms ->
    for (i in 1..MAX_NUM) {
        for (j in i..MAX_NUM) {
            lcms[i][j] = i / gcd(i, j) * j
            lcms[j][i] = lcms[i][j]
        }
    }
}

private val MU = IntArray(MAX_NUM + 1).also { mu ->
    mu[1] = 1
    for (i in 1..MAX_NUM) {
        var j = i + i
        while (j <= MAX_NUM) {
            mu[j] -= mu[i]
            j += i
        }
    }
}

class Solution {
    fun subsequencePairCount(nums: IntArray): Int {
        val mx = nums.max()
        val cnt = IntArray(mx + 1)
        for (x in nums) {
            ++cnt[x]
        }
        for (i in 1..mx) {
            var j = i + i
            while (j <= mx) {
                cnt[i] = (cnt[i] + cnt[j]) % MOD
                j += i
            }
        }
        val f = Array(mx + 1) { IntArray(mx + 1) }
        for (g1 in 1..mx) {
            for (g2 in g1..mx) {
                val l = LCM[g1][g2]
                val c = if (l < cnt.size) cnt[l] else 0
                val c1 = cnt[g1]
                val c2 = cnt[g2]
                val value = ((POW3[c].toLong() * POW2[(c1 - c) + (c2 - c)] -
                    POW2[c1] - POW2[c2] + 1) % MOD + MOD) % MOD
                f[g1][g2] = value.toInt()
                f[g2][g1] = f[g1][g2]
            }
        }
        fun count(g: Int): Int {
            var result = 0
            for (i in 1..mx / g) {
                for (j in 1..mx / g) {
                    result = ((result + MU[i] * MU[j] * f[i * g][j * g]) % MOD + MOD) % MOD
                }
            }
            return result
        }

        var result = 0
        for (g in 1..mx) {
            result = (result + count(g)) % MOD
        }
        return result
    }
}
