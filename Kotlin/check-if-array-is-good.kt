package checkifarrayisgood

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isGood(nums: IntArray): Boolean {
        val cnt = IntArray(nums.size)
        for (x in nums) {
            if (x < cnt.size) {
                ++cnt[x]
            } else {
                return false
            }
        }
        for (i in 1..nums.size - 2) {
            if (cnt[i] != 1) {
                return false
            }
        }
        return true
    }
}
