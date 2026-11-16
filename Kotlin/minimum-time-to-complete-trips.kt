package minimumtimetocompletetrips

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        fun check(x: Long): Boolean {
            var total = 0L
            for (t in time) {
                total += x / t
            }
            return total >= totalTrips
        }

        var left = 1L
        var right = time.max().toLong() * totalTrips
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
