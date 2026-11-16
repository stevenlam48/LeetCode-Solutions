package sumofconsecutivesubsequences

// Time:  O(n)
// Space: O(n)

// combinatorics, prefix sum, freq table, dp
class Solution {
    fun getSum(nums: IntArray): Int {
        val MOD = 1_000_000_007
        fun count(d: Int): Int {
            var result = 0
            val cnt = HashMap<Int, Int>()
            val prefix = HashMap<Int, Int>()
            for (x in nums) {
                val c = ((cnt[x - d] ?: 0) + 1) % MOD
                cnt[x] = ((cnt[x] ?: 0) + c) % MOD
                val total = ((prefix[x - d] ?: 0) + (x.toLong() * c % MOD).toInt()) % MOD
                prefix[x] = ((prefix[x] ?: 0) + total) % MOD
                result = (result + total) % MOD
            }
            return result
        }

        var sum = 0L
        for (x in nums) {
            sum = (sum + x) % MOD
        }
        return (((count(1) + count(-1)) % MOD - sum % MOD + MOD) % MOD).toInt()
    }
}
