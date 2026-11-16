package distributerepeatingintegers
// Time:  O(n + m * 3^m) 
// Space: O(n + 2^m)

class Solution {
    fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {
        val count = HashMap<Int, Int>()
        for (num in nums) {
            count[num] = (count[num] ?: 0) + 1
        }
        val total = (1 shl quantity.size) - 1
        val requirement = IntArray(total + 1)
        for (mask in requirement.indices) {
            for (i in quantity.indices) {
                if (mask and (1 shl i) != 0) {
                    requirement[mask] += quantity[i]
                }
            }
        }
        val dp = Array(2) { IntArray(total + 1) }
        dp[0][0] = 1
        val cnts = count.values.sortedDescending().take(quantity.size)
        for (i in cnts.indices) {
            dp[(i + 1) % 2].fill(0)
            for (mask in total downTo 0) {
                dp[(i + 1) % 2][mask] = dp[(i + 1) % 2][mask] or dp[i % 2][mask]
                var submask = mask
                while (submask > 0) {
                    if (requirement[submask] <= cnts[i] && dp[i % 2][mask xor submask] != 0) {
                        dp[(i + 1) % 2][mask] = 1
                    }
                    submask = (submask - 1) and mask
                }
            }
        }
        return dp[cnts.size % 2][total] != 0
    }
}
