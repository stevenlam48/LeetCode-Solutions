package minimumsumofsquareddifference

// Time:  O(nlogn + nlogr), r is max((abs(i-j) for i, j in itertools.izip(nums1, nums2))
// Space: O(n)

import kotlin.math.abs

class Solution {
    fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
        val diffs = LongArray(nums1.size)
        for (i in diffs.indices) {
            diffs[i] = abs(nums1[i].toLong() - nums2[i].toLong())
        }
        diffs.sortDescending()
        var k = minOf(k1.toLong() + k2, diffs.sum())
        val check = { x: Int ->
            diffs.sumOf { d -> maxOf(d - x, 0L) } <= k
        }
        var left = 0L
        var right = diffs[0]
        while (left <= right) {
            val mid = (left + (right - left) / 2).toInt()
            if (check(mid)) {
                right = mid.toLong() - 1
            } else {
                left = mid.toLong() + 1
            }
        }
        k -= diffs.sumOf { d -> maxOf(d - left, 0L) }
        for (i in diffs.indices) {
            diffs[i] = minOf(diffs[i], left) - if (i.toLong() < k) 1 else 0
        }
        return diffs.sumOf { d -> d * d }
    }
}
