package minimumswapstogroupall1stogetherii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSwaps(nums: IntArray): Int {
        val n = nums.size
        val w = nums.count { it == 1 }
        var result = w
        var cnt = w
        for (i in 0 until n + (w - 1)) {
            if (i >= w) {
                cnt += nums[(i - w) % n]
            }
            cnt -= nums[i % n]
            result = minOf(result, cnt)
        }
        return result
    }
}
