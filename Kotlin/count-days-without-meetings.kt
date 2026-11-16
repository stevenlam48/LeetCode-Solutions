package countdayswithoutmeetings

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        meetings.sortWith(compareBy({ it[0] }, { it[1] }))
        var result = 0
        var curr = 0
        for (m in meetings) {
            result += maxOf((m[0] - 1) - curr, 0)
            curr = maxOf(curr, m[1])
        }
        result += maxOf(days - curr, 0)
        return result
    }
}
