package minimizeproductsumoftwoarrays

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        nums2.sortDescending()
        var result = 0
        for (i in nums1.indices) {
            result += nums1[i] * nums2[i]
        }
        return result
    }
}
