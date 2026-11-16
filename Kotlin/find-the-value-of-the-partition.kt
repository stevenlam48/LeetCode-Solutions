package findthevalueofthepartition

// Time:  O(nlogn)
// Space: O(1)

// sort
class Solution {
    fun findValueOfPartition(nums: IntArray): Int {
        nums.sort()
        var result = Int.MAX_VALUE
        for (i in 0 until nums.size - 1) {
            result = minOf(result, nums[i + 1] - nums[i])
        }
        return result
    }
}
