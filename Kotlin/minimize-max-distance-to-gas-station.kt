package minimizemaxdistancetogasstation
// Time:  O(nlogr)
// Space: O(1)

import kotlin.math.ceil

class Solution {
    fun minmaxGasDist(stations: IntArray, K: Int): Double {
        fun check(x: Double): Boolean {
            var total = 0
            for (i in 0 until stations.size - 1) {
                total += ceil((stations[i + 1] - stations[i]) / x).toInt() - 1
            }
            return total <= K
        }

        var left = 0.0
        var right = (stations.last() - stations.first()).toDouble()
        while (right - left > 1e-6) {
            val mid = left + (right - left) / 2.0
            if (check(mid)) {
                right = mid
            } else {
                left = mid
            }
        }
        return left
    }
}
