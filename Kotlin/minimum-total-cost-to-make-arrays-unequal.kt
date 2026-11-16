package minimumtotalcosttomakearraysunequal

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumTotalCost(nums1: IntArray, nums2: IntArray): Long {
        val counts = HashMap<Int, Int>()
        var result = 0L
        for (i in nums1.indices) {
            if (nums1[i] == nums2[i]) {
                counts[nums1[i]] = (counts[nums1[i]] ?: 0) + 1
                result += i
            }
        }
        if (counts.isEmpty()) {
            return 0
        }
        val majority = counts.entries.maxByOrNull { it.value }!!.key
        var remain = counts[majority]!! - (counts.values.sum() - counts[majority]!!)
        if (remain <= 0) {
            return result
        }
        for (i in nums1.indices) {
            if (nums1[i] == nums2[i] || nums1[i] == majority || nums2[i] == majority) {
                continue
            }
            result += i
            if (--remain == 0) {
                return result
            }
        }
        return -1
    }
}
