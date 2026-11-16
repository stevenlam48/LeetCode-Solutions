package elevatorrequestsii

// Time:  O(m^2), m = len(requests)
// Space: O(m)

class Solution {
    fun elevatorRequests(n: Int, start: Int, requests: IntArray): Long {
        val floors = requests.toMutableList()
        if (start !in floors) {
            floors.add(start)
        }
        floors.sort()
        val k = floors.indexOf(start)
        var dp = Array(2) { LongArray(floors.size) { Long.MAX_VALUE } }
        dp[0][k] = 0
        dp[1][k] = 0
        for (l in 1 until floors.size) {
            val newDp = Array(2) { LongArray(floors.size) { Long.MAX_VALUE } }
            for (i in maxOf(k - l + 1, 0)..minOf(floors.size - l, k)) {
                val j = i + l - 1
                if (i - 1 >= 0) {
                    if (dp[0][i] != Long.MAX_VALUE) {
                        newDp[0][i - 1] = minOf(
                            newDp[0][i - 1],
                            dp[0][i] + (floors[i] - floors[i - 1]).toLong() * (floors.size - l)
                        )
                    }
                    if (dp[1][i] != Long.MAX_VALUE) {
                        newDp[0][i - 1] = minOf(
                            newDp[0][i - 1],
                            dp[1][i] + (floors[j] - floors[i - 1]).toLong() * (floors.size - l)
                        )
                    }
                }
                if (j + 1 < floors.size) {
                    if (dp[0][i] != Long.MAX_VALUE) {
                        newDp[1][i] = minOf(
                            newDp[1][i],
                            dp[0][i] + (floors[j + 1] - floors[i]).toLong() * (floors.size - l)
                        )
                    }
                    if (dp[1][i] != Long.MAX_VALUE) {
                        newDp[1][i] = minOf(
                            newDp[1][i],
                            dp[1][i] + (floors[j + 1] - floors[j]).toLong() * (floors.size - l)
                        )
                    }
                }
            }
            dp = newDp
        }
        return minOf(dp[0][0], dp[1][0])
    }
}
