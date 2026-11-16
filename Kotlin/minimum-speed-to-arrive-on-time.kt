package minimumspeedtoarriveontime

// Time:  O(nlogr), r is the range of speed
// Space: O(1)

class Solution {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        val maxSpeed = 10_000_000
        if (!check(dist, hour, maxSpeed)) {
            return -1
        }
        var left = 1
        var right = maxSpeed
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(dist, hour, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun ceil(a: Int, b: Int): Int {
        return (a + b - 1) / b
    }

    private fun totalTime(dist: IntArray, x: Int): Double {
        var total = 0
        for (i in 0 until dist.size - 1) {
            total += ceil(dist[i], x)
        }
        return total + dist.last().toDouble() / x
    }

    private fun check(dist: IntArray, hour: Double, x: Int): Boolean {
        return totalTime(dist, x) <= hour
    }
}
