package totalcharactersinstringaftertransformationsi

// Time:  precompute: O(t + 26)
//        runtime:    O(n)
// Space: O(t + 26)

class Solution {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        var result = 0L
        for (x in s) {
            result = (result + DP[(x - 'a') + t]) % MOD
        }
        return result.toInt()
    }

    companion object {
        private const val MOD = 1_000_000_007L
        private const val MAX_T = 100_000

        private val DP = IntArray(MAX_T + 26).also { dp ->
            for (i in 0 until 26) {
                dp[i] = 1
            }
            for (i in 26 until dp.size) {
                dp[i] = ((dp[i - 26] + dp[(i - 26) + 1]) % MOD).toInt()
            }
        }
    }
}
