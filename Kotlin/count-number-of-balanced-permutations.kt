package countnumberofbalancedpermutations

// Time:  O(9 * (9 * n / 2) * (n / 2)) = O(n^2)
// Space: O((9 * n / 2) * (n / 2)) = O(n^2)

class Solution {
    fun countBalancedPermutations(num: String): Int {
        val mod = 1_000_000_007
        val fact = mutableListOf(1, 1)
        val inv = mutableListOf(1, 1)
        val invFact = mutableListOf(1, 1)

        fun lazyInit(n: Int) {
            while (inv.size <= n) {
                fact.add((fact.last().toLong() * inv.size % mod).toInt())
                inv.add((inv[mod % inv.size].toLong() * (mod - mod / inv.size) % mod).toInt())
                invFact.add((invFact.last().toLong() * inv.last() % mod).toInt())
            }
        }

        fun nCr(n: Int, k: Int): Int {
            lazyInit(n)
            return ((fact[n].toLong() * invFact[n - k] % mod) * invFact[k] % mod).toInt()
        }

        fun factorial(n: Int): Int {
            lazyInit(n)
            return fact[n]
        }

        fun invFactorial(n: Int): Int {
            lazyInit(n)
            return invFact[n]
        }

        var total = 0
        for (x in num) {
            total += x - '0'
        }
        if (total % 2 != 0) {
            return 0
        }
        total /= 2
        val cnt = IntArray(26)
        for (x in num) {
            ++cnt[x - '0']
        }
        val even = num.length / 2
        val dp = Array(total + 1) { IntArray(even + 1) }
        dp[0][0] = 1
        for (i in cnt.indices) {
            if (cnt[i] == 0) {
                continue
            }
            for (j in total downTo 0) {
                for (k in even downTo 0) {
                    if (dp[j][k] == 0) {
                        continue
                    }
                    for (c in 1..cnt[i]) {
                        if (j + c * i <= total && k + c <= even) {
                            dp[j + c * i][k + c] = ((dp[j + c * i][k + c] +
                                dp[j][k].toLong() * nCr(cnt[i], c) % mod) % mod).toInt()
                        }
                    }
                }
            }
        }
        var result = ((dp[total][even].toLong() * factorial(even) % mod) *
            factorial(num.length - even) % mod).toInt()
        for (x in cnt) {
            result = (result.toLong() * invFactorial(x) % mod).toInt()
        }
        return result
    }
}
