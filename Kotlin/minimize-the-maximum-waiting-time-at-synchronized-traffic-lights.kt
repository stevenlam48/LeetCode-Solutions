package minimizethemaximumwaitingtimeatsynchronizedtrafficlights

// Time:  O(n + m)
// Space: O(1)

class Solution {
    fun minPenalty(period: Int, lights: IntArray, arrivalTime: IntArray): Int {
        val mx = lights.max()
        var result = 0
        for (a in arrivalTime) {
            val x = a % period
            if (x < mx) {
                continue
            }
            result = maxOf(result, period - x)
        }
        return result
    }
}
