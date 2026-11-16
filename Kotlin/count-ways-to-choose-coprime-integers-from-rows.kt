package countwaystochoosecoprimeintegersfromrows

// Time:  O(n * (m + rlogr)), r = max(max(row) for row in mat)
// Space: O(r)

class Solution {
    fun countCoprime(mat: Array<IntArray>): Int {
        val mod = 1_000_000_007

        var mx = 0
        for (row in mat) {
            for (x in row) {
                mx = maxOf(mx, x)
            }
        }

        val spf = IntArray(mx + 1) { -1 }
        val primes = mutableListOf<Int>()
        for (i in 2..mx) {
            if (spf[i] == -1) {
                spf[i] = i
                primes.add(i)
            }
            for (p in primes) {
                if (i * p > mx || p > spf[i]) {
                    break
                }
                spf[i * p] = p
            }
        }

        val mu = IntArray(mx + 1)
        for (i in 1..mx) {
            mu[i] = if (i == 1) 1 else if (spf[i / spf[i]] == spf[i]) 0 else -mu[i / spf[i]]
        }

        val dp = LongArray(mx + 1) { 1L }
        for (row in mat) {
            val cnt = IntArray(mx + 1)
            for (x in row) {
                ++cnt[x]
            }
            for (i in 1..mx) {
                var total = 0L
                var j = i
                while (j <= mx) {
                    total = (total + cnt[j]) % mod
                    j += i
                }
                dp[i] = dp[i] * total % mod
            }
        }
        var result = 0L
        for (i in 1..mx) {
            result = (result + (((dp[i] * mu[i]) % mod + mod) % mod)) % mod
        }
        return result.toInt()
    }
}
