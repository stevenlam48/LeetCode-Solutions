package findtheintegeraddedtoarrayi

// Time:  O(n)
// Space: O(1)

class Solution {
    fun addedInteger(nums1: IntArray, nums2: IntArray): Int {
        return nums2.max() - nums1.max()
    }
}
