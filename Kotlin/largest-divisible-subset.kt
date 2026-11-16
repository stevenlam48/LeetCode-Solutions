package largestdivisiblesubset

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun largestDivisibleSubset(nums: IntArray): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf()
        }
        nums.sort()
        val dp = IntArray(nums.size) { 1 }
        val prev = IntArray(nums.size) { -1 }
        var largestIdx = 0
        for (i in nums.indices) {
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1
                    prev[i] = j
                }
            }
            if (dp[largestIdx] < dp[i]) {
                largestIdx = i
            }
        }
        val result = mutableListOf<Int>()
        var i = largestIdx
        while (i != -1) {
            result.add(nums[i])
            i = prev[i]
        }
        result.reverse()
        return result.toIntArray()
    }
}
