package minimummovestopickkones

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumMoves(nums: IntArray, k: Int, maxChanges: Int): Long {
        val idxs = ArrayList<Int>()
        for (i in nums.indices) {
            if (nums[i] != 0) {
                idxs.add(i)
            }
        }
        val prefix = LongArray(idxs.size + 1)
        for (i in idxs.indices) {
            prefix[i + 1] = prefix[i] + idxs[i]
        }
        val cnt = maxOf(k - maxChanges, 0)
        val bound = minOf(cnt + 3, k, idxs.size)
        var result = Long.MAX_VALUE
        var l = cnt
        while (l <= bound) {
            val cnt1 = (k - l) * 2L
            var i = 0
            while (i + l < prefix.size) {
                val cnt2 = (prefix[(i + l - 1) + 1] - prefix[(i + l - 1) - (l / 2 - 1)]) -
                           (prefix[(i + (l / 2 - 1)) + 1] - prefix[i])
                result = minOf(result, cnt2 + cnt1)
                ++i
            }
            ++l
        }
        return result
    }
}
