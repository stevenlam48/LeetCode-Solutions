package maximizeexpressionofthreeelements

// Time:  O(n)
// Space: O(1)

// math
class Solution {
    fun maximizeExpressionOfThree(nums: IntArray): Int {
        var i = 0
        for (j in nums.indices) {
            if (nums[j] > nums[i]) i = j
        }
        var t = nums[i]
        nums[i] = nums[nums.size - 1]
        nums[nums.size - 1] = t

        var j = 0
        for (k in 0 until nums.size - 1) {
            if (nums[k] > nums[j]) j = k
        }
        t = nums[j]
        nums[j] = nums[nums.size - 2]
        nums[nums.size - 2] = t

        var k = 0
        for (l in 0 until nums.size - 2) {
            if (nums[l] < nums[k]) k = l
        }
        t = nums[k]
        nums[k] = nums[0]
        nums[0] = t

        return nums[nums.size - 1] + nums[nums.size - 2] - nums[0]
    }
}
