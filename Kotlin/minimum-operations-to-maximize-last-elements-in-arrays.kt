package minimumoperationstomaximizelastelementsinarrays

// Time:  O(n)
// Space: O(1)

// simulation
class Solution {
    fun minOperations(nums1: IntArray, nums2: IntArray): Int {
        var cnt1 = 0
        var cnt2 = 0
        val a = nums1[nums1.size - 1]
        val b = nums2[nums2.size - 1]
        for (i in nums1.indices) {
            if (!(minOf(nums1[i], nums2[i]) <= minOf(a, b) &&
                    maxOf(nums1[i], nums2[i]) <= maxOf(a, b))) {
                return -1
            }
            if (!(nums1[i] <= a && nums2[i] <= b)) {
                ++cnt1
            }
            if (!(nums1[i] <= b && nums2[i] <= a)) {
                ++cnt2
            }
        }
        return minOf(cnt1, cnt2)
    }
}
