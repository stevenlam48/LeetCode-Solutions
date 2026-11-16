package countelementswithstrictlysmallerandgreaterelements

// Time:  O(n)
// Space: O(1)

// math
class Solution {
    fun countElements(nums: IntArray): Int {
        val mn = nums.minOrNull()!!
        val mx = nums.maxOrNull()!!
        return nums.count { mn < it && it < mx }
    }
}
