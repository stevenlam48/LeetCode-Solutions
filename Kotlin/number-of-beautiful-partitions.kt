package numberofbeautifulpartitions

// Time:  O(n * k)
// Space: O(n)

class Solution {
    fun beautifulPartitions(s: String, k: Int, minLength: Int): Int {
        val MOD = 1000000007
        val PRIMES = setOf('2', '3', '5', '7')
        var dp = IntArray(s.length)
        for (i in s.indices) {
            if (s[0] in PRIMES && s[i] !in PRIMES) {
                dp[i] = 1
            }
        }
        for (j in 2..k) {
            val newDp = IntArray(s.length)
            var curr = 0
            var i = j * minLength - 1
            while (i < s.length) {
                if (s[i - minLength + 1] in PRIMES) {
                    curr = (curr + dp[i - minLength]) % MOD
                }
                if (s[i] !in PRIMES) {
                    newDp[i] = curr
                }
                ++i
            }
            dp = newDp
        }
        return dp.last()
    }
}
