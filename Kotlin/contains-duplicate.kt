package containsduplicate
// Time:  O(n)
// Space: O(n)

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val numsSet = nums.toHashSet()
        return numsSet.size != nums.size
    }
}
