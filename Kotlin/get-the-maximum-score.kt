package getthemaximumscore

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun maxSum(nums1: IntArray, nums2: IntArray): Int {
        val mod = 1_000_000_007L
        var result = 0L
        var sum1 = 0L
        var sum2 = 0L
        var i = 0
        var j = 0
        while (i != nums1.size || j != nums2.size) {
            if (i != nums1.size && (j == nums2.size || nums1[i] < nums2[j])) {
                sum1 += nums1[i]
                i++
            } else if (j != nums2.size && (i == nums1.size || nums1[i] > nums2[j])) {
                sum2 += nums2[j]
                j++
            } else {
                result = (result + maxOf(sum1, sum2) + nums1[i]) % mod
                sum1 = 0
                sum2 = 0
                i++
                j++
            }
        }
        return ((result + maxOf(sum1, sum2)) % mod).toInt()
    }
}
