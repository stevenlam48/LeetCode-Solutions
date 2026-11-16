package containsduplicateii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val lookup = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (nums[i] !in lookup) {
                lookup[nums[i]] = i
            } else {
                if (i - lookup[nums[i]]!! <= k) {
                    return true
                }
                lookup[nums[i]] = i
            }
        }
        return false
    }
}
