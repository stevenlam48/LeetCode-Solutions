package maximumnumberofpairsinarray

// Time:  O(n + r)
// Space: O(r), r = max(nums)

class Solution {
    fun numberOfPairs(nums: IntArray): IntArray {
        val cnt = IntArray(nums.max() + 1)
        var pairCnt = 0
        for (x in nums) {
            cnt[x] = cnt[x] xor 1
            if (cnt[x] == 0) {
                ++pairCnt
            }
        }
        return intArrayOf(pairCnt, nums.size - 2 * pairCnt)
    }
}
