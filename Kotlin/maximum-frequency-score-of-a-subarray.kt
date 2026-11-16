package maximumfrequencyscoreofasubarray

// Time:  O(n)
// Space: O(n)

// two pointers, sliding window, freq table, hash table
class Solution {
    fun maxFrequencyScore(nums: IntArray, k: Int): Int {
        val MOD = 1_000_000_007
        val lookup = HashMap<Int, HashMap<Int, Int>>()
        fun powmod(n: Int, p: Int): Int {
            val m = lookup.getOrPut(n) { HashMap() }
            if (!m.containsKey(p)) {
                m[p] = if (p >= 2) (m[p - 1]!!.toLong() * n % MOD).toInt() else n % MOD
            }
            return m[p]!!
        }

        var result = 0
        var curr = 0
        val cnt = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (i >= k) {
                curr = ((curr - powmod(nums[i - k], cnt[nums[i - k]]!!)) % MOD + MOD) % MOD
                cnt[nums[i - k]] = cnt[nums[i - k]]!! - 1
                if (cnt[nums[i - k]]!! > 0) {
                    curr = (curr + powmod(nums[i - k], cnt[nums[i - k]]!!)) % MOD
                }
            }
            if ((cnt[nums[i]] ?: 0) > 0) {
                curr = ((curr - powmod(nums[i], cnt[nums[i]]!!)) % MOD + MOD) % MOD
            }
            cnt[nums[i]] = (cnt[nums[i]] ?: 0) + 1
            curr = (curr + powmod(nums[i], cnt[nums[i]]!!)) % MOD
            if (i >= k - 1) {
                result = maxOf(result, curr)
            }
        }
        return result
    }
}
