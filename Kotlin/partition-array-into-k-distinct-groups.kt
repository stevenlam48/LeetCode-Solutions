package partitionarrayintokdistinctgroups

// Time:  O(n)
// Space: O(n)

// math, freq table
class Solution {
    fun partitionArray(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0) {
            return false
        }
        val groupCnt = nums.size / k
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            val c = (cnt[x] ?: 0) + 1
            cnt[x] = c
            if (c > groupCnt) {
                return false
            }
        }
        return true
    }
}
