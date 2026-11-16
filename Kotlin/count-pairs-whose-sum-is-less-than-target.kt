package countpairswhosesumislessthantarget

// Time:  O(nlogn)
// Space: O(1)

// sort, two pointers
class Solution {
    fun countPairs(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = 0
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                result += right - left
                ++left
            } else {
                --right
            }
        }
        return result
    }
}
