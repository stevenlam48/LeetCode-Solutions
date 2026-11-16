package minimumdifferencebetweenhighestandlowestofkscores
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        nums.sort()
        var result = Int.MAX_VALUE
        for (i in k - 1 until nums.size) {
            result = minOf(result, nums[i] - nums[i - k + 1])
        }
        return result
    }
}
