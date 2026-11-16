package chalkboardxorgam

// Time:  O(n)
// Space: O(1)

class Solution {
    fun xorGame(nums: IntArray): Boolean {
        return nums.reduce { acc, num -> acc xor num } == 0 || nums.size % 2 == 0
    }
}
