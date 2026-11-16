package numberofstudentsdoinghomeworkatagiventime
// Time:  O(n)
// Space: O(1)

class Solution {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var result = 0
        for (i in startTime.indices) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ++result
            }
        }
        return result
    }
}
