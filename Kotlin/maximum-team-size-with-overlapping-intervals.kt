package maximumteamsizewithoverlappingintervals
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maximumTeamSize(startTime: IntArray, endTime: IntArray): Int {
        val sortedStart = startTime.sortedArray()
        val sortedEnd = endTime.sortedArray()
        var result = 0
        for (i in startTime.indices) {
            val left = lowerBound(sortedEnd, startTime[i])
            val right = upperBound(sortedStart, endTime[i])
            result = maxOf(result, right - left)
        }
        return result
    }

    private fun lowerBound(a: IntArray, x: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (a[mid] < x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    private fun upperBound(a: IntArray, x: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (a[mid] <= x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}
