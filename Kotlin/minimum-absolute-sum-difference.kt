package minimumabsolutesumdifference

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
        val mod = 1_000_000_007
        val sortedNums1 = nums1.copyOf()
        sortedNums1.sort()
        var result = 0
        var maxChange = 0
        for (i in nums2.indices) {
            val diff = Math.abs(nums1[i] - nums2[i])
            result = (result + diff) % mod
            if (diff < maxChange) {
                continue
            }
            val cit = lowerBound(sortedNums1, nums2[i])
            if (cit != sortedNums1.size) {
                maxChange = maxOf(maxChange, diff - Math.abs(sortedNums1[cit] - nums2[i]))
            }
            if (cit != 0) {
                maxChange = maxOf(maxChange, diff - Math.abs(sortedNums1[cit - 1] - nums2[i]))
            }
        }
        return (result - maxChange + mod) % mod
    }

    private fun lowerBound(a: IntArray, x: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (a[mid] < x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}
