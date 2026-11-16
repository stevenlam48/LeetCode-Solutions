package numberofeffectivesubsequences

// Time:  O((n + r) * logr), r = max(nums)
// Space: O(n + r)

// sos dp, principle of inclusion and exclusion
class Solution {
    fun countEffective(nums: IntArray): Int {
        val MOD = 1_000_000_007

        fun bitLength(x: Int): Int = if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 0

        var total = 0
        for (x in nums) {
            total = total or x
        }
        val l = bitLength(total)
        val bits = ArrayList<Int>()
        for (i in 0 until l) {
            if ((total and (1 shl i)) != 0) {
                bits.add(i)
            }
        }
        val dp = IntArray(1 shl bits.size)
        for (x in nums) {
            var mask = 0
            for (i in bits.indices) {
                if ((x and (1 shl bits[i])) != 0) {
                    mask = mask or (1 shl i)
                }
            }
            dp[mask]++
        }
        for (i in bits.indices) {
            for (mask in dp.indices) {
                if ((mask and (1 shl i)) != 0) {
                    dp[mask] += dp[mask xor (1 shl i)]
                }
            }
        }
        val cnt = IntArray(1 shl bits.size)
        for (mask in 1 until cnt.size) {
            cnt[mask] = cnt[mask and (mask - 1)] + 1
        }
        val pow2 = IntArray(nums.size + 1)
        pow2[0] = 1
        for (i in nums.indices) {
            pow2[i + 1] = (pow2[i].toLong() * 2 % MOD).toInt()
        }
        var result = 0L
        val full = (1 shl bits.size) - 1
        for (mask in 1 until cnt.size) {
            val sign = if ((cnt[mask] and 1) != 0) 1L else -1L
            result = ((result + sign * pow2[dp[full xor mask]]) % MOD + MOD) % MOD
        }
        return result.toInt()
    }
}
