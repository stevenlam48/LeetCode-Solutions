package minimumflipstomakebinarystringcoherent

// Time:  O(n)
// Space: O(1)

// greedy, case works
class Solution {
    fun minFlips(s: String): Int {
        val cnt0 = s.count { it == '0' }
        val cnt1 = s.length - cnt0
        return minOf(
            cnt0,
            maxOf(cnt1 - 1, 0),
            maxOf(cnt1 - (if (s[0] == '1') 1 else 0) - (if (s[s.length - 1] == '1') 1 else 0), 0)
        )
    }
}
