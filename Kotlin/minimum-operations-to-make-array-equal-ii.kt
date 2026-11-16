package minimumoperationstomakearrayequalii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(nums1: IntArray, nums2: IntArray, k: Int): Long {
        var cnt1 = 0L
        var cnt2 = 0L
        for (i in nums1.indices) {
            if (nums1[i] == nums2[i]) {
                continue
            }
            if (k == 0 || (nums1[i] - nums2[i]) % k != 0) {
                return -1
            }
            if (nums1[i] < nums2[i]) {
                cnt1 += (nums2[i] - nums1[i]).toLong() / k
            } else {
                cnt2 += (nums1[i] - nums2[i]).toLong() / k
            }
        }
        return if (cnt1 == cnt2) cnt1 else -1
    }
}
