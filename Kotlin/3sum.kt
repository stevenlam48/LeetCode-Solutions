package p3sum

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun threeSum(nums: IntArray): Array<IntArray> {
        nums.sort()
        val result = ArrayList<IntArray>()
        for (i in nums.size - 1 downTo 2) {
            if (i + 1 < nums.size && nums[i] == nums[i + 1]) {
                continue
            }
            val target = -nums[i]
            var left = 0
            var right = i - 1
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    ++left
                } else if (nums[left] + nums[right] > target) {
                    --right
                } else {
                    result.add(intArrayOf(nums[left], nums[right], nums[i]))
                    ++left
                    --right
                    while (left < right && nums[left] == nums[left - 1]) {
                        ++left
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        --right
                    }
                }
            }
        }
        return result.toTypedArray()
    }
}
