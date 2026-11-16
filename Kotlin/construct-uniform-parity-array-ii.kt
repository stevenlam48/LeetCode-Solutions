package constructuniformparityarrayii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun uniformArray(nums1: IntArray): Boolean {
        return nums1.min() % 2 == 1 || nums1.all { it % 2 == 0 }
    }
}
