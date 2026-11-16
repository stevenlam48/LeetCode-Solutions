package findpolygonwiththelargestperimeter

// Time:  O(nlogn)
// Space: O(1)

// sort, prefix sum, greedy
class Solution {
    fun largestPerimeter(nums: IntArray): Long {
        nums.sort()
        var prefix = 0L
        for (x in nums) {
            prefix += x
        }
        for (i in nums.size - 1 downTo 2) {
            prefix -= nums[i]
            if (prefix > nums[i]) {
                return prefix + nums[i]
            }
        }
        return -1L
    }
}
