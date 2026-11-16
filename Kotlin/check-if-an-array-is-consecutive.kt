package checkifanarrayisconsecutive

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isConsecutive(nums: IntArray): Boolean {
        return (nums.max().toLong() - nums.min() + 1) == nums.size.toLong() &&
            nums.size == nums.toHashSet().size
    }
}
