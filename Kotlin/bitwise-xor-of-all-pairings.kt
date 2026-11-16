package bitwisexorofallpairings

// Time:  O(n)
// Space: O(1)

// bit manipulation
class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        var result = 0
        if (nums2.size % 2 == 1) {
            var x = 0
            for (v in nums1) {
                x = x xor v
            }
            result = result xor x
        }
        if (nums1.size % 2 == 1) {
            var x = 0
            for (v in nums2) {
                x = x xor v
            }
            result = result xor x
        }
        return result
    }
}
