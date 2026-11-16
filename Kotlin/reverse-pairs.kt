package reversepairs
// Time:  O(nlogn)
// Space: O(logn)

class Solution {
    fun reversePairs(nums: IntArray): Int {
        return countAndMergeSort(nums, 0, nums.size)
    }

    private fun countAndMergeSort(nums: IntArray, begin: Int, end: Int): Int {
        if (end - begin <= 1) return 0
        val mid = begin + (end - begin) / 2
        var count = countAndMergeSort(nums, begin, mid) + countAndMergeSort(nums, mid, end)
        var right = mid
        for (left in begin until mid) {
            while (right < end && nums[left] > 2L * nums[right]) ++right
            count += right - mid
        }
        val merged = IntArray(end - begin)
        var left = begin
        right = mid
        var index = 0
        while (left < mid && right < end) {
            merged[index++] = if (nums[left] <= nums[right]) nums[left++] else nums[right++]
        }
        while (left < mid) merged[index++] = nums[left++]
        while (right < end) merged[index++] = nums[right++]
        for (i in merged.indices) nums[begin + i] = merged[i]
        return count
    }
}
