package widestpairofindiceswithequalrangesum

// Time:  O(n)
// Space: O(n)

class Solution {
    fun widestPairOfIndices(nums1: IntArray, nums2: IntArray): Int {
        val lookup = hashMapOf<Long, Int>(0L to -1)
        var result = 0
        var total = 0L
        for (i in nums1.indices) {
            total += nums1[i] - nums2[i]
            if (total !in lookup) {
                lookup[total] = i
            }
            result = maxOf(result, i - lookup.getValue(total))
        }
        return result
    }
}
