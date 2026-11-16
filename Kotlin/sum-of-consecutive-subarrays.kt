package sumofconsecutivesubarrays

// Time:  O(n)
// Space: O(1)

// combinatorics
class Solution {
    fun getSum(nums: IntArray): Int {
        val MOD = 1_000_000_007
        fun count(d: Int): Long {
            var result = 0L
            var total = 0L
            var cnt = 0L
            for (i in nums.indices) {
                cnt += 1
                total = (total + cnt * nums[i]) % MOD
                result = (result + total) % MOD
                if (i + 1 < nums.size && nums[i + 1] - nums[i] == d) {
                    continue
                }
                total = 0
                cnt = 0
            }
            return result
        }

        var sum = 0L
        for (x in nums) {
            sum = (sum + x) % MOD
        }
        return (((count(1) + count(-1) - sum) % MOD + MOD) % MOD).toInt()
    }
}
