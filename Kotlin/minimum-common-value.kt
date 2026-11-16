package minimumcommonvalue

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] < nums2[j] -> ++i
                nums1[i] > nums2[j] -> ++j
                else -> return nums1[i]
            }
        }
        return -1
    }
}
