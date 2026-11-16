package minimumnumberofgroupstocreateavalidassignment

// Time:  O(min(cnt.values()) * n/min(cnt.values())) = O(n)
// Space: O(n)

// linear search, greedy, math
class Solution {
    fun minGroupsForValidAssignment(nums: IntArray): Int {
        val inf = Int.MAX_VALUE

        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }

        fun count(x: Int): Int {
            var result = 0
            for (c in cnt.values) {
                if (c % x > c / x) {
                    return inf
                }
                result += ceilDivide(c, x + 1)
            }
            return result
        }

        var minCnt = inf
        for (c in cnt.values) {
            minCnt = minOf(minCnt, c)
        }
        for (i in minCnt downTo 1) {
            val c = count(i)
            if (c != inf) {
                return c
            }
        }
        return 0
    }
}
