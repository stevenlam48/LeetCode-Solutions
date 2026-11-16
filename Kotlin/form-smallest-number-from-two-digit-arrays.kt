package formsmallestnumberfromtwodigitarrays

// Time:  O(m + n)
// Space: O(m + n)

class Solution {
    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        var mn = Int.MAX_VALUE
        val lookup = nums1.toHashSet()
        for (x in nums2) {
            if (x in lookup) {
                mn = minOf(mn, x)
            }
        }
        if (mn != Int.MAX_VALUE) {
            return mn
        }
        var mn1 = nums1.minOrNull()!!
        var mn2 = nums2.minOrNull()!!
        if (mn1 > mn2) {
            val temp = mn1
            mn1 = mn2
            mn2 = temp
        }
        return 10 * mn1 + mn2
    }
}
