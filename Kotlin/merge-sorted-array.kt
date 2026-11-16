package mergesortedarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var first = m
        var second = n
        var i = m + n
        while (first > 0 && second > 0) {
            if (nums1[first - 1] > nums2[second - 1]) {
                nums1[i - 1] = nums1[first - 1]
                --first
            } else {
                nums1[i - 1] = nums2[second - 1]
                --second
            }
            --i
        }
        while (second > 0) {
            nums1[i - 1] = nums2[second - 1]
            --second
            --i
        }
    }
}
