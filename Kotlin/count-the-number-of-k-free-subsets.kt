package countthenumberofkfreesubsets
// Time:  O(n)
// Space: O(n)

class Solution {
    fun countTheNumOfKFreeSubsets(nums: IntArray, k: Int): Long {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = cnt.getOrDefault(x, 0) + 1
        }
        fun count(x: Int): Long {
            var y = x
            while (cnt.containsKey(y - k)) {
                y -= k
            }
            var dp0 = 1L
            var dp1 = 0L
            var i = y
            while (i <= x) {
                val nextDp0 = dp0 + dp1
                val nextDp1 = dp0 * ((1 shl cnt.getValue(i)) - 1)
                dp0 = nextDp0
                dp1 = nextDp1
                i += k
            }
            return dp0 + dp1
        }
        var result = 1L
        for (i in cnt.keys) {
            if (!cnt.containsKey(i + k)) {
                result *= count(i)
            }
        }
        return result
    }
}
