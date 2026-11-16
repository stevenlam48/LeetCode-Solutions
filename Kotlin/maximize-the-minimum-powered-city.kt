package maximizetheminimumpoweredcity

// Time:  O(nlogk)
// Space: O(n)

class Solution {
    fun maxPower(stations: IntArray, r: Int, k: Int): Long {
        val n = stations.size
        var mn = Long.MAX_VALUE
        var curr = 0L
        for (i in 0 until minOf(r, n)) {
            curr += stations[i]
        }
        for (i in 0 until n) {
            if (i + r < n) {
                curr += stations[i + r]
            }
            if (i >= r + 1) {
                curr -= stations[i - (r + 1)]
            }
            mn = minOf(mn, curr)
        }

        fun check(target: Long): Boolean {
            val arr = stations.copyOf()
            var power = 0L
            for (i in 0 until minOf(r, n)) {
                power += arr[i]
            }
            var cnt = k.toLong()
            for (i in 0 until n) {
                if (i + r < n) {
                    power += arr[i + r]
                }
                if (i >= r + 1) {
                    power -= arr[i - (r + 1)]
                }
                if (power >= target) {
                    continue
                }
                val diff = target - power
                if (diff > cnt) {
                    return false
                }
                cnt -= diff
                power += diff
                if (i + r < n) {
                    arr[i + r] += diff.toInt()
                }
            }
            return true
        }

        var left = mn
        var right = mn + k
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }
}
