package minimumnumberofworksessionstofinishthetasks

// Time:  O(n * 2^n)
// Space: O(2^n)

class Solution {
    fun minSessions(tasks: IntArray, sessionTime: Int): Int {
        // dp[mask]: min used time by choosing tasks in mask bitset
        val dp = IntArray(1 shl tasks.size) { Int.MAX_VALUE }
        dp[0] = 0
        for (mask in 0 until dp.size - 1) {
            var basis = 1
            for (t in tasks) {
                val newMask = mask or basis
                basis = basis shl 1
                if (newMask == mask) {
                    continue
                }
                var task = t
                if (dp[mask] % sessionTime + task > sessionTime) {
                    task += sessionTime - dp[mask] % sessionTime  // take a break
                }
                dp[newMask] = minOf(dp[newMask], dp[mask] + task)
            }
        }
        return (dp.last() + sessionTime - 1) / sessionTime
    }
}
