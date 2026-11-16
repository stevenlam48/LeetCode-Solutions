package intersectionoftwoarraysii
// Time:  O(m + n)
// Space: O(min(m, n))

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.size > nums2.size) {
            return intersect(nums2, nums1)
        }
        val lookup = HashMap<Int, Int>()
        for (value in nums1) {
            lookup[value] = lookup.getOrDefault(value, 0) + 1
        }
        val result = mutableListOf<Int>()
        for (value in nums2) {
            if (lookup.getOrDefault(value, 0) > 0) {
                result.add(value)
                lookup[value] = lookup.getValue(value) - 1
            }
        }
        return result.toIntArray()
    }
}
