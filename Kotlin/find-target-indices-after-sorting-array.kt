package findtargetindicesaftersortingarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun targetIndices(nums: IntArray, target: Int): IntArray {
        val less = nums.count { it < target }
        val equal = nums.count { it == target }
        return IntArray(equal) { less + it }
    }
}
