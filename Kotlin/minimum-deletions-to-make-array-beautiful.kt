package minimumdeletionstomakearraybeautiful
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minDeletion(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size - 1) {
            if (i % 2 == result % 2 && nums[i] == nums[i + 1]) {
                ++result
            }
        }
        return result + (nums.size - result) % 2
    }
}
