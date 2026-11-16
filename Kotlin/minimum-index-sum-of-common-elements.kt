package minimumindexsumofcommonelements
// Time:  O(n + m)
// Space: O(n)

class Solution {
    fun minimumSum(nums1: IntArray, nums2: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        for (i in nums1.indices) {
            if (lookup.containsKey(nums1[i])) {
                continue
            }
            lookup[nums1[i]] = i
        }
        var result = Int.MAX_VALUE
        for (j in nums2.indices) {
            if (lookup.containsKey(nums2[j])) {
                result = minOf(result, lookup[nums2[j]]!! + j)
            }
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
