package removeelement

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            if (nums[left] != `val`) {
                ++left
            } else {
                --right
                val tmp = nums[left]
                nums[left] = nums[right]
                nums[right] = tmp
            }
        }
        return right
    }
}
