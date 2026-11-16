package intersectionoftwoarrays
// Time:  O(m + n)
// Space: O(min(m, n))

class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.size > nums2.size) {
            return intersection(nums2, nums1)
        }
        val lookup = nums1.toHashSet()
        val result = mutableListOf<Int>()
        for (value in nums2) {
            if (lookup.contains(value)) {
                result.add(value)
                lookup.remove(value)
            }
        }
        return result.toIntArray()
    }
}
