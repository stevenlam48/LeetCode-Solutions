package countpairsintwoarrays

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun countPairs(nums1: IntArray, nums2: IntArray): Long {
        for (i in nums1.indices) {
            nums1[i] -= nums2[i]
        }
        nums1.sort()
        var result = 0L
        var left = 0
        var right = nums1.size - 1
        while (left < right) {
            if (nums1[left] > 0 || -nums1[left] < nums1[right]) {
                result += right - left
                --right
            } else {
                ++left
            }
        }
        return result
    }
}
