package smalleststableindexi
// Time:  O(n)
// Space: O(n)

class Solution {
    fun firstStableIndex(nums: IntArray, k: Int): Int {
        val right = IntArray(nums.size + 1) { Int.MAX_VALUE }
        for (i in nums.lastIndex downTo 0) {
            right[i] = minOf(right[i + 1], nums[i])
        }
        var left = 0
        for (i in nums.indices) {
            left = maxOf(left, nums[i])
            if (left - right[i] <= k) {
                return i
            }
        }
        return -1
    }
}
