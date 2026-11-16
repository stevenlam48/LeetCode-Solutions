package minimumtimetorepaircars

// Time:  O(mx * log(mn * c^2)) = O(mx * (logc + log(mn))), c = cars, mx = max(ranks), mn = min(ranks)
// Space: O(mx)

import kotlin.math.sqrt

class Solution {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        val counts = HashMap<Int, Int>()
        for (rank in ranks) {
            counts[rank] = (counts[rank] ?: 0) + 1
        }

        fun check(x: Long): Boolean {
            var total = 0L
            for ((rank, count) in counts) {
                total += sqrt((x / rank).toDouble()).toLong() * count
            }
            return total >= cars
        }

        val minimumRank = counts.keys.min()
        var left = 1L
        var right = minimumRank.toLong() * cars * cars
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
