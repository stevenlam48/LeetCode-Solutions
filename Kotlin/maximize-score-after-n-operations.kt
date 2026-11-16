package maximizescoreafternoperations
// Time:  O(n^2 * 2^n)
// Space: O(2^n)

class Solution {
    fun maxScore(nums: IntArray): Int {
        val dp = IntArray(1 shl nums.size)
        for (mask in 3 until dp.size) {
            val cnt = mask.countOneBits()
            if (cnt % 2 != 0) {
                continue
            }
            val bits = mutableListOf<Int>()
            var m = mask
            var i = 0
            while (m != 0) {
                if ((m and 1) != 0) {
                    bits.add(i)
                }
                ++i
                m = m ushr 1
            }
            for (i in bits.indices) {
                for (j in i + 1 until bits.size) {
                    dp[mask] = maxOf(
                        dp[mask],
                        cnt / 2 * gcd(nums[bits[i]], nums[bits[j]]) +
                            dp[mask xor (1 shl bits[i]) xor (1 shl bits[j])]
                    )
                }
            }
        }
        return dp.last()
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
