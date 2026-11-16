package medianoftwosortedarrays
// Time:  O(log(min(m, n)))
// Space: O(1)

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        fun findKthInTwoSortedArrays(a0: IntArray, b0: IntArray, k: Int): Int {
            var a = a0
            var b = b0
            var m = a.size
            var n = b.size
            if (m > n) {
                val size = m
                m = n
                n = size
                val array = a
                a = b
                b = array
            }

            var left = maxOf(k - n, 0)
            var right = minOf(m, k) - 1
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (a[mid] >= b[k - 1 - mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            val i = left
            val aiMinus1 = if (i - 1 >= 0) a[i - 1] else Int.MIN_VALUE
            val bj = if (k - 1 - i >= 0) b[k - 1 - i] else Int.MIN_VALUE
            return maxOf(aiMinus1, bj)
        }

        val total = nums1.size + nums2.size
        if (total % 2 == 1) {
            return findKthInTwoSortedArrays(nums1, nums2, total / 2 + 1).toDouble()
        }
        val first = findKthInTwoSortedArrays(nums1, nums2, total / 2)
        val second = findKthInTwoSortedArrays(nums1, nums2, total / 2 + 1)
        return (first.toLong() + second.toLong()) / 2.0
    }
}
