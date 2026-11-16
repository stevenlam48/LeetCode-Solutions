package minimumoperationstotransformarray

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minOperations(nums1: IntArray, nums2: IntArray): Long {
        var result = 0L
        var cnt = Int.MAX_VALUE
        for (i in nums1.indices) {
            result += abs(nums1[i] - nums2[i])
            if ((nums2.last() - nums1[i]).toLong() * (nums2.last() - nums2[i]) <= 0L) {
                cnt = 0
            }
            cnt = minOf(cnt, abs(nums2.last() - nums1[i]), abs(nums2.last() - nums2[i]))
        }
        result += 1L + cnt
        return result
    }
}
