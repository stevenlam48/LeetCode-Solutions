package splitthearray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isPossibleToSplit(nums: IntArray): Boolean {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            val count = (cnt[x] ?: 0) + 1
            cnt[x] = count
            if (count > 2) {
                return false
            }
        }
        return true
    }
}
