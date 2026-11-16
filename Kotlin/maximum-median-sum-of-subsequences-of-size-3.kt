package maximummediansumofsubsequencesofsize3

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumMedianSum(nums: IntArray): Long {
        nums.sort()
        var result = 0L
        var i = nums.size / 3
        while (i < nums.size) {
            result += nums[i]
            i += 2
        }
        return result
    }
}
