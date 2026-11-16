package mirrorfrequencydistance

// Time:  O(n + 36)
// Space: O(36)

// freq table
class Solution {
    fun mirrorFrequency(s: String): Int {
        val cnt1 = IntArray(10)
        val cnt2 = IntArray(26)
        for (x in s) {
            if (x.isDigit()) {
                ++cnt1[x - '0']
            } else {
                ++cnt2[x - 'a']
            }
        }
        var result = 0
        var i = 0
        while (2 * i < cnt1.size) {
            result += Math.abs(cnt1[i] - cnt1[cnt1.size - 1 - i])
            ++i
        }
        i = 0
        while (2 * i < cnt2.size) {
            result += Math.abs(cnt2[i] - cnt2[cnt2.size - 1 - i])
            ++i
        }
        return result
    }
}
