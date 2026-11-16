package minimumcosttoequalizearraysusingswaps
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minCost(nums1: IntArray, nums2: IntArray): Int {
        val cnt = HashMap<Int, Int>()
        for (x in nums1) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        for (x in nums2) {
            cnt[x] = (cnt[x] ?: 0) - 1
        }
        var result = 0
        for (c in cnt.values) {
            if (c % 2 != 0) {
                return -1
            }
            if (c / 2 > 0) {
                result += c / 2
            }
        }
        return result
    }
}
