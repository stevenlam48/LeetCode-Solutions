package minimumtimedifference

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val n = 60 * 24
        val minutes = timePoints.map { it.substring(0, 2).toInt() * 60 + it.substring(3).toInt() }.sorted()
        var result = Int.MAX_VALUE
        for (i in minutes.indices) {
            result = minOf(result, (n + minutes[(i + 1) % minutes.size] - minutes[i]) % n)
        }
        return result
    }
}
