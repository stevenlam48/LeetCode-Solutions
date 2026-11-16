package numberofunequaltripletsinarray
// Time:  O(n * k) = O(3 * n)
// Space: O(n + k) = O(n)

class Solution {
    fun unequalTriplets(nums: IntArray): Int {
        val count = HashMap<Int, Int>()
        val dp = IntArray(3)
        for (value in nums) {
            count[value] = count.getOrDefault(value, 0) + 1
            var otherCount = 1
            for (i in dp.indices) {
                dp[i] += otherCount
                otherCount = dp[i] - count.getValue(value) * otherCount
            }
        }
        return dp[2]
    }
}
