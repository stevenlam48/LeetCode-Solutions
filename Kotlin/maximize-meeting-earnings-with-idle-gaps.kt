package maximizemeetingearningswithidlegaps

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxEarnings(meetings: Array<IntArray>): Long {
        meetings.sortWith { a, b ->
            when {
                a[0] != b[0] -> a[0].compareTo(b[0])
                a[1] != b[1] -> a[1].compareTo(b[1])
                else -> a[2].compareTo(b[2])
            }
        }
        val idxs = meetings.indices.sortedBy { meetings[it][1] }.toIntArray()
        var result = 0L
        val dp = LongArray(meetings.size)
        var idx = 0
        var mx = Long.MIN_VALUE
        for (i in meetings.indices) {
            val s = meetings[i][0].toLong()
            val r = meetings[i][2].toLong()
            while (meetings[idxs[idx]][1].toLong() <= s) {
                mx = maxOf(mx, dp[idxs[idx]] - meetings[idxs[idx]][1].toLong())
                ++idx
            }
            dp[i] = r + maxOf(s + mx, 0L)
            result = maxOf(result, dp[i])
        }
        return result
    }
}
