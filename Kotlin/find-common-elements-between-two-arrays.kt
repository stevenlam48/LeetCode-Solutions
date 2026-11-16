package findcommonelementsbetweentwoarrays

// Time:  O(n + m)
// Space: O(n + m)

// hash table
class Solution {
    fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
        val lookup1 = nums1.toHashSet()
        val lookup2 = nums2.toHashSet()
        return intArrayOf(
            nums1.count { it in lookup2 },
            nums2.count { it in lookup1 }
        )
    }
}
