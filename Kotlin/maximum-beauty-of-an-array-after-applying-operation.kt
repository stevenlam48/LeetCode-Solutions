package maximumbeautyofanarrayafterapplyingoperation

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        nums.sort()
        var right = 0
        var left = 0
        while (right < nums.size) {
            if (nums[right].toLong() - nums[left] > k.toLong() * 2) {
                ++left
            }
            ++right
        }
        return right - left
    }
}
