package numberofwaystodividealongcorridor

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfWays(corridor: String): Int {
        val MOD = 1_000_000_007
        var result = 1L
        var cnt = 0
        var j = -1
        for (i in corridor.indices) {
            if (corridor[i] != 'S') {
                continue
            }
            ++cnt
            if (cnt >= 3 && cnt % 2 == 1) {
                result = result * (i - j) % MOD
            }
            j = i
        }
        return if (cnt != 0 && cnt % 2 == 0) result.toInt() else 0
    }
}
