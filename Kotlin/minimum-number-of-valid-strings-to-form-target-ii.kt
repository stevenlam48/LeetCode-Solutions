package minimumnumberofvalidstringstoformtargetii

// Time:  O(n + w * l)
// Space: O(n + w * l)

class Solution {
    fun minValidStrings(words: List<String>, target: String): Int {
        val power = LongArray(target.length + 1)
        power[0] = 1
        for (i in target.indices) {
            power[i + 1] = power[i] * P % MOD
        }
        val lookup = HashSet<Long>()
        for (w in words) {
            var h = 0L
            for (x in w) {
                h = (h * P + (x - 'a' + 1)) % MOD
                lookup.add(h)
            }
        }
        val dp = IntArray(target.length + 1)
        var left = 0
        var h = 0L
        for (right in target.indices) {
            h = (h * P + (target[right] - 'a' + 1)) % MOD
            while (right - left + 1 >= 1 && h !in lookup) {
                h = ((h - (target[left] - 'a' + 1) * power[right - left]) % MOD + MOD) % MOD
                ++left
            }
            if (right - left + 1 == 0) {
                return -1
            }
            dp[right + 1] = dp[(right - (right - left + 1)) + 1] + 1
        }
        return dp[target.length]
    }

    private companion object {
        const val MOD = 1_000_000_007
        const val P = 131
    }
}
