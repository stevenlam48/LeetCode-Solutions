package mergeoperationsforminimumtraveltime
// Time:  O((n - k) * k^3)
// Space: O(k^2)

class Solution {
    fun minTravelTime(l: Int, n: Int, k: Int, position: IntArray, time: IntArray): Int {
        val inf = Int.MAX_VALUE
        val prefix = IntArray(n + 1)
        for (i in 0 until n) {
            prefix[i + 1] = prefix[i] + time[i]
        }
        var dp = hashMapOf(0 to hashMapOf(time[0] to 0))
        for (cnt in 2..n - k) {
            val newDp = hashMapOf<Int, HashMap<Int, Int>>()
            for (i in cnt - 1 until cnt + k) {
                for (j in cnt - 2 until i) {
                    for ((t, c) in dp[j].orEmpty()) {
                        val nt = prefix[i + 1] - prefix[j + 1]
                        val state = newDp.getOrPut(i) { hashMapOf() }
                        state[nt] = minOf(state.getOrDefault(nt, inf), (position[i] - position[j]) * t + c)
                    }
                }
            }
            dp = newDp
        }
        var result = inf
        for (c in dp[n - 1].orEmpty().values) {
            result = minOf(result, c)
        }
        return result
    }
}
