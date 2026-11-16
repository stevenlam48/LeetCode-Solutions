package smallestpairwithdifferentfrequencies
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minDistinctFreqPair(nums: IntArray): IntArray {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        val x = nums.min()
        var mn = Int.MAX_VALUE
        for (y in nums) {
            if (cnt[y] != cnt[x]) {
                mn = minOf(mn, y)
            }
        }
        return if (mn != Int.MAX_VALUE) intArrayOf(x, mn) else intArrayOf(-1, -1)
    }
}
