package countcompletesubarraysinanarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countCompleteSubarrays(nums: IntArray): Int {
        val numsSet = nums.toHashSet()
        var result = 0
        var left = 0
        val cnt = HashMap<Int, Int>()
        for (right in nums.indices) {
            cnt[nums[right]] = (cnt[nums[right]] ?: 0) + 1
            while (cnt.size == numsSet.size) {
                val value = nums[left++]
                cnt[value] = cnt[value]!! - 1
                if (cnt[value] == 0) {
                    cnt.remove(value)
                }
            }
            result += left
        }
        return result
    }
}
