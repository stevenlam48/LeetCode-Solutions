package minimumnumberofdaystomakembouquets

// Time:  O(nlogd), d is the max day of bloomDay
// Space: O(1)

class Solution {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (m * k > bloomDay.size) {
            return -1
        }
        var left = 1
        var right = bloomDay.max()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(bloomDay, m, k, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun check(bloomDay: IntArray, m: Int, k: Int, x: Int): Boolean {
        var result = 0
        var count = 0
        for (d in bloomDay) {
            count = if (d <= x) count + 1 else 0
            if (count == k) {
                count = 0
                if (++result == m) {
                    break
                }
            }
        }
        return result >= m
    }
}
