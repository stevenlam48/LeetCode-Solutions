package meetingrooms
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        for (i in 1 until intervals.size) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false
            }
        }
        return true
    }
}
