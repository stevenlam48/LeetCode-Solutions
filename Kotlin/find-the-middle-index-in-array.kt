package findthemiddleindexinarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findMiddleIndex(nums: IntArray): Int {
        val total = nums.sum()
        var accu = 0
        for (i in nums.indices) {
            if (accu * 2 == total - nums[i]) {
                return i
            }
            accu += nums[i]
        }
        return -1
    }
}
