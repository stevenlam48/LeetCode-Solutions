package minimumequalsumoftwoarraysafterreplacingzeros

// Time:  O(n + m)
// Space: O(1)

// greedy
class Solution {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        val add = { accu: Long, x: Int -> accu + maxOf(x, 1) }

        val total1 = nums1.fold(0L, add)
        val total2 = nums2.fold(0L, add)
        if (total1 < total2) {
            return if (nums1.any { it == 0 }) total2 else -1L
        }
        if (total1 > total2) {
            return if (nums2.any { it == 0 }) total1 else -1L
        }
        return total1
    }
}
