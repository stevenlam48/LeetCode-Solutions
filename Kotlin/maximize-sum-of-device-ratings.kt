package maximizesumofdeviceratings

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun maxRatings(units: Array<IntArray>): Long {
        fun top2(nums: IntArray): Pair<Int, Int> {
            var mn1 = Int.MAX_VALUE
            var mn2 = Int.MAX_VALUE
            for (x in nums) {
                if (x < mn1) {
                    mn2 = mn1
                    mn1 = x
                } else if (x < mn2) {
                    mn2 = x
                }
            }
            return mn1 to mn2
        }

        if (units[0].size == 1) {
            var total = 0L
            for (row in units) {
                total += row[0]
            }
            return total
        }
        var total = 0L
        var mn1 = Int.MAX_VALUE
        var mn2 = Int.MAX_VALUE
        for (row in units) {
            val (m1, m2) = top2(row)
            total += m2
            mn1 = minOf(mn1, m1)
            mn2 = minOf(mn2, m2)
        }
        return total - mn2 + mn1
    }
}
