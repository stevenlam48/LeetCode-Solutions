package minimumnumberoftapstoopentowateragarden

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minTaps(n: Int, ranges: IntArray): Int {
        val maxRange = IntArray(n + 1)
        for (i in ranges.indices) {
            val left = maxOf(i - ranges[i], 0)
            val right = minOf(i + ranges[i], n)
            maxRange[left] = maxOf(maxRange[left], right - left)
        }
        return jumpGame(maxRange)
    }

    private fun jumpGame(a: IntArray): Int {
        var jumpCount = 0
        var reachable = 0
        var currReachable = 0
        for (i in a.indices) {
            if (i > reachable) {
                return -1
            }
            if (i > currReachable) {
                currReachable = reachable
                ++jumpCount
            }
            reachable = maxOf(reachable, i + a[i])
        }
        return jumpCount
    }
}
