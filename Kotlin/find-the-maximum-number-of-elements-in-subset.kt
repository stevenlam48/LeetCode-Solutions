package findthemaximumnumberofelementsinsubset
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumLength(nums: IntArray): Int {
        val cnt = HashMap<Long, Int>()
        for (x in nums) {
            val key = x.toLong()
            cnt[key] = (cnt[key] ?: 0) + 1
        }
        val dp = HashMap<Long, Int>()
        var result = 0
        for ((key, _) in cnt) {
            var x = key
            if (x == 1L) {
                result = maxOf(result, cnt[x]!! - if (cnt[x]!! % 2 == 0) 1 else 0)
                continue
            }
            val stk = mutableListOf<Int>()
            while (!dp.containsKey(x) && cnt.containsKey(x) && cnt[x]!! >= 2) {
                stk.add(x.toInt())
                x *= x
            }
            if (!dp.containsKey(x)) {
                if (!cnt.containsKey(x)) {
                    x = stk.removeAt(stk.lastIndex).toLong()
                }
                dp[x] = 1
            }
            var l = dp[x]!!
            while (stk.isNotEmpty()) {
                l += 2
                dp[stk.removeAt(stk.lastIndex).toLong()] = l
            }
            result = maxOf(result, l)
        }
        return result
    }
}
