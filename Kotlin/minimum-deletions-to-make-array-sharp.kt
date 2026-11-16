package minimumdeletionstomakearraysharp
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minDeletions(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                ++result
            }
        }
        return result
    }
}
