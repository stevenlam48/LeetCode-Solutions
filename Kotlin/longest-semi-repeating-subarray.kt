package longestsemirepeatingsubarray
// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestSubarray(nums: IntArray, k: Int): Int {
        val counts = HashMap<Int, Int>()
        var left = 0
        var repeat = 0
        for (right in nums.indices) {
            val count = counts.getOrDefault(nums[right], 0) + 1
            counts[nums[right]] = count
            if (count == 2) {
                ++repeat
            }
            if (repeat > k) {
                val leftCount = counts.getValue(nums[left])
                counts[nums[left]] = leftCount - 1
                if (leftCount == 2) {
                    --repeat
                }
                if (leftCount - 1 == 0) {
                    counts.remove(nums[left])
                }
                ++left
            }
        }
        return nums.size - left
    }
}
