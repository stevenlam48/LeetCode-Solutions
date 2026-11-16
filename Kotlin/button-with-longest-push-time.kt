package buttonwithlongestpushtime

// Time:  O(n)
// Space: O(1)

class Solution {
    fun buttonWithLongestTime(events: Array<IntArray>): Int {
        var maxTime = events[0][1]
        var index = events[0][0]
        for (i in 1 until events.size) {
            val diff = events[i][1] - events[i - 1][1]
            if (diff > maxTime || (diff == maxTime && events[i][0] < index)) {
                maxTime = diff
                index = events[i][0]
            }
        }
        return index
    }
}
