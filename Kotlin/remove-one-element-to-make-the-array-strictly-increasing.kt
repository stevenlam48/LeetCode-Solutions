package removeoneelementtomakethearraystrictlyincreasing

// Time:  O(n)
// Space: O(1)
class Solution {
    fun canBeIncreasing(nums: IntArray): Boolean {
        var deleted = false
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                continue
            }
            if (deleted) {
                return false
            }
            deleted = true
            if (i >= 2 && nums[i - 2] > nums[i]) { // delete nums[i] or nums[i-1]
                nums[i] = nums[i - 1]
            }
        }
        return true
    }
}
