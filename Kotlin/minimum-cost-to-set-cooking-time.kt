package minimumcosttosetcookingtime

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minCostSetTime(startAt: Int, moveCost: Int, pushCost: Int, targetSeconds: Int): Int {
        fun cost(m: Int, s: Int): Int {
            if (!(0 <= m && m <= 99 && s <= 99)) {
                return Int.MAX_VALUE
            }
            var result = 0
            var curr = startAt
            for (ch in (m * 100 + s).toString()) {
                val x = ch - '0'
                result += (if (x != curr) moveCost else 0) + pushCost
                curr = x
            }
            return result
        }

        val m = targetSeconds / 60
        val s = targetSeconds % 60
        return minOf(cost(m, s), cost(m - 1, s + 60))
    }
}
