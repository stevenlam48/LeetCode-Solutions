package thenumberoffullroundsyouhaveplayed

// Time:  O(1)
// Space: O(1)

class Solution {
    fun numberOfRounds(startTime: String, finishTime: String): Int {
        val start = startTime.substring(0, 2).toInt() * 60 + startTime.substring(3).toInt()
        var finish = finishTime.substring(0, 2).toInt() * 60 + finishTime.substring(3).toInt()
        if (start > finish) {
            finish += 1440
        }
        return Math.max(finish / 15 - (start + 15 - 1) / 15, 0)
    }
}
