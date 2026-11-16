package thenumberofbeautifulsubsets

// Time:  O(n)
// Space: O(n)

class Solution {
    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }

        fun count(x: Int): Int {
            var y = x
            while (cnt.containsKey(y - k)) {
                y -= k
            }
            var dp0 = 1
            var dp1 = 0
            var i = y
            while (i <= x) {
                val next0 = dp0 + dp1
                val next1 = dp0 * ((1 shl cnt[i]!!) - 1)
                dp0 = next0
                dp1 = next1
                i += k
            }
            return dp0 + dp1
        }

        var result = 1
        for (i in cnt.keys) {
            if (!cnt.containsKey(i + k)) {
                result *= count(i)
            }
        }
        return result - 1
    }
}
