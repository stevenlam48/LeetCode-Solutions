package choosenumbersfromtwoarraysinrange

// Time:  O(n^2 * v), v is max(max(nums1), max(nums2))
// Space: O(n * v)

class Solution {
    fun countSubranges(nums1: IntArray, nums2: IntArray): Int {
        val mod = 1_000_000_007
        var result = 0
        var dp = HashMap<Int, Int>()
        for (i in nums1.indices) {
            val newDp = HashMap<Int, Int>()
            newDp[nums1[i]] = (newDp[nums1[i]] ?: 0) + 1
            newDp[-nums2[i]] = (newDp[-nums2[i]] ?: 0) + 1
            for ((v, c) in dp) {
                val takeFromFirst = v + nums1[i]
                newDp[takeFromFirst] = ((newDp[takeFromFirst] ?: 0) + c) % mod
                val takeFromSecond = v - nums2[i]
                newDp[takeFromSecond] = ((newDp[takeFromSecond] ?: 0) + c) % mod
            }
            dp = newDp
            dp[0]?.let {
                result = (result + it) % mod
            }
        }
        return result
    }
}
