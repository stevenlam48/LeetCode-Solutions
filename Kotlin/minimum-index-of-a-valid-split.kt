package minimumindexofavalidsplit
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumIndex(nums: IntArray): Int {
        var m = 0
        var count = 0
        for (x in nums) {
            if (count == 0) {
                m = x
            }
            if (x == m) {
                ++count
            } else {
                --count
            }
        }
        val total = nums.count { it == m }
        var prefixCount = 0
        for (i in nums.indices) {
            if (nums[i] == m) {
                ++prefixCount
            }
            if (prefixCount * 2 > i + 1 && (total - prefixCount) * 2 > nums.size - (i + 1)) {
                return i
            }
        }
        return -1
    }
}
