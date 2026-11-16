package kthsmallestproductoftwosortedarrays

// Time:  O((m + n) * logr), r is the range size of [min(products), max(products)]
// Space: O(1)

class Solution {
    fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
        val negCnt = nums1.count { it < 0 }
        var left = Long.MAX_VALUE
        var right = Long.MIN_VALUE
        for (i in listOf(0, nums1.lastIndex)) {
            for (j in listOf(0, nums2.lastIndex)) {
                left = minOf(left, nums1[i].toLong() * nums2[j])
                right = maxOf(right, nums1[i].toLong() * nums2[j])
            }
        }
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(nums1, nums2, k, negCnt, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun check(nums1: IntArray, nums2: IntArray, k: Long, negCnt: Int, target: Long): Boolean {
        var start = if (target >= 0) negCnt - 1 else 0
        var end = if (target >= 0) -1 else negCnt
        var d = if (target >= 0) -1 else 1
        var cnt = 0L
        var left = 0
        var right = nums2.lastIndex
        var i = start
        while (i != end) {
            while (left < nums2.size && nums1[i].toLong() * nums2[left] > target) {
                ++left
            }
            cnt += nums2.lastIndex - left + 1
            i += d
        }
        start = if (target >= 0) negCnt else nums1.lastIndex
        end = if (target >= 0) nums1.size else negCnt - 1
        d = if (target >= 0) 1 else -1
        i = start
        while (i != end) {
            if (nums1[i] == 0) {
                if (target >= 0) {
                    cnt += nums2.size
                }
                i += d
                continue
            }
            while (right >= 0 && nums1[i].toLong() * nums2[right] > target) {
                --right
            }
            cnt += right + 1
            i += d
        }
        return cnt >= k
    }
}
