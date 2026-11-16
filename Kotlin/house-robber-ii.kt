package houserobberii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }

        return maxOf(
            robRange(nums, 0, nums.size - 1),
            robRange(nums, 1, nums.size)
        )
    }

    fun robRange(nums: IntArray, start: Int, end: Int): Int {
        var numI = nums[start]
        var numI1 = 0
        var numI2 = 0
        for (i in start + 1 until end) {
            numI2 = numI1
            numI1 = numI
            numI = maxOf(nums[i] + numI2, numI1)
        }
        return numI
    }
}
