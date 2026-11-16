package minimizelengthofarrayusingoperations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumArrayLength(nums: IntArray): Int {
        val mn = nums.min()
        return if (nums.all { it % mn == 0 }) {
            (nums.count { it == mn } + 1) / 2
        } else {
            1
        }
    }
}
