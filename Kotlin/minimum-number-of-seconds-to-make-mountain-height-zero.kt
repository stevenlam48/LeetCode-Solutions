package minimumnumberofsecondstomakemountainheightzero

// Time:  O(nlogr), r = min(workerTimes) * (mountainHeight + 1) * mountainHeight / 2
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
        val mn = workerTimes.minOrNull()!!.toLong()
        var left = mn
        var right = mn * (mountainHeight + 1) * mountainHeight / 2
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (canFinish(mountainHeight, workerTimes, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun canFinish(mountainHeight: Int, workerTimes: IntArray, target: Long): Boolean {
        var total = 0L
        for (t in workerTimes) {
            total += ((-1 + sqrt(1 + 8.0 * target / t)) / 2).toInt()
        }
        return total >= mountainHeight
    }
}
