package maximumprofitinjobscheduling

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobs = ArrayList<Triple<Int, Int, Int>>()
        for (i in startTime.indices) {
            jobs.add(Triple(endTime[i], startTime[i], profit[i]))
        }
        jobs.sortWith(compareBy({ it.first }, { it.second }, { it.third }))
        val dp = ArrayList<Pair<Int, Int>>()
        dp.add(0 to 0)
        for ((e, s, p) in jobs) {
            var lo = 0
            var hi = dp.size
            while (lo < hi) {
                val mid = (lo + hi) / 2
                val cmp = if (dp[mid].first != s + 1) {
                    dp[mid].first.compareTo(s + 1)
                } else {
                    dp[mid].second.compareTo(0)
                }
                if (cmp <= 0) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            val idx = lo - 1
            if (dp[idx].second + p > dp.last().second) {
                dp.add(e to dp[idx].second + p)
            }
        }
        return dp.last().second
    }
}
