package degreeofanarray

// Time:  O(n)
// Space: O(n)
class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
        val left = HashMap<Int, Int>()
        val right = HashMap<Int, Int>()
        val counts = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (!left.containsKey(nums[i])) left[nums[i]] = i
            right[nums[i]] = i
            counts[nums[i]] = (counts[nums[i]] ?: 0) + 1
        }
        val degree = counts.values.max()
        var result = Int.MAX_VALUE
        for ((num, count) in counts) {
            if (count == degree) result = minOf(result, right[num]!! - left[num]!! + 1)
        }
        return result
    }
}
