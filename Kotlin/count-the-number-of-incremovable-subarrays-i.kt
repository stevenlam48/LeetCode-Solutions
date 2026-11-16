package countthenumberofincremovablesubarraysi

// Time:  O(n)
// Space: O(1)

// two pointers
class Solution {
    fun incremovableSubarrayCount(nums: IntArray): Long {
        var j = nums.size - 1
        while (j >= 1) {
            if (!(nums[j - 1] < nums[j])) {
                break
            }
            --j
        }
        if (j == 0) {
            return (nums.size + 1).toLong() * nums.size / 2
        }
        var result = (nums.size - j + 1).toLong()
        var i = 0
        while (i + 1 < nums.size) {
            while (j < nums.size && !(nums[i] < nums[j])) {
                ++j
            }
            result += nums.size - j + 1
            if (!(nums[i] < nums[i + 1])) {
                break
            }
            ++i
        }
        return result
    }
}
