package maximumtotalvalue

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun maxTotalValue(value: IntArray, decay: IntArray, m: Int): Int {
        val mod = 1000000007
        fun total(x: Int): Pair<Int, Long> {
            var result = 0
            var count = 0L
            for (i in value.indices) {
                if (value[i] - x < 0) {
                    continue
                }
                val t = (value[i] - x) / decay[i] + 1L
                result = if (t % 2 == 0L) {
                    ((result + (value[i] + (value[i] - decay[i] * (t - 1))) * (t / 2)) % mod).toInt()
                } else {
                    ((result + (value[i] - decay[i] * ((t - 1) / 2)) * t) % mod).toInt()
                }
                count += t
            }
            return result to count
        }
        fun check(x: Int): Boolean = total(x).second <= m
        if (check(1)) {
            return total(1).first
        }
        var left = 2
        var right = value.max()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        val x = left
        val (totalValue, count) = total(x)
        return ((totalValue + (m - count) * (x - 1)) % mod).toInt()
    }
}
