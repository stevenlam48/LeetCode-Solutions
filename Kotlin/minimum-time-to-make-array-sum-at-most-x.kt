package minimumtimetomakearraysumatmostx

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minimumTime(nums1: IntArray, nums2: IntArray, x: Int): Int {
        val indices = nums1.indices.sortedBy { nums2[it] }
        val dp = IntArray(nums1.size + 1)
        for (i in indices.indices) {
            val a = nums1[indices[i]]
            val b = nums2[indices[i]]
            for (j in i + 1 downTo 1) {
                dp[j] = maxOf(dp[j], dp[j - 1] + a + j * b)
            }
        }
        val total1 = nums1.sum()
        val total2 = nums2.sum()
        for (j in dp.indices) {
            if (total1 + j * total2 - dp[j] <= x) {
                return j
            }
        }
        return -1
    }
}
