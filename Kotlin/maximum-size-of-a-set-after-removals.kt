package maximumsizeofasetafterremovals

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumSetSize(nums1: IntArray, nums2: IntArray): Int {
        val lookup1 = nums1.toHashSet()
        val lookup2 = nums2.toHashSet()
        val common = HashSet<Int>()
        for (x in lookup1) {
            if (x in lookup2) {
                common.add(x)
            }
        }
        val n = nums1.size
        val n1 = lookup1.size
        val n2 = lookup2.size
        val c = common.size
        val d1 = minOf(n1 - c, n / 2)
        val d2 = minOf(n2 - c, n / 2)
        return minOf(n, d1 + d2 + c)
    }
}
