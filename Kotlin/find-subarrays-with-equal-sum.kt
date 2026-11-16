package findsubarrayswithequalsum

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun findSubarrays(nums: IntArray): Boolean {
        val lookup = mutableSetOf<Int>()
        for (i in 0 until nums.size - 1) {
            if (!lookup.add(nums[i] + nums[i + 1])) {
                return true
            }
        }
        return false
    }
}
