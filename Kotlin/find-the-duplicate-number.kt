package findtheduplicatenumber

// Time:  O(n)
// Space: O(1)
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }
        fast = 0
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }
        return slow
    }
}
