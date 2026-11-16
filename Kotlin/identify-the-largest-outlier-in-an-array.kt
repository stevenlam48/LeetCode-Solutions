package identifythelargestoutlierinanarray

// Time:  O(n)
// Space: O(n)

// freq table
class Solution {
    fun getLargestOutlier(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        val total = nums.sum()
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        for (x in nums) {
            if ((total - x) % 2 != 0) {
                continue
            }
            val target = (total - x) / 2
            val targetCount = cnt[target]
            if (targetCount != null && targetCount - (if (target == x) 1 else 0) >= 1) {
                result = maxOf(result, x)
            }
        }
        return result
    }
}
