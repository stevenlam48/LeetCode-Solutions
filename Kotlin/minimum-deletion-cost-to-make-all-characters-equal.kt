package minimumdeletioncosttomakeallcharactersequal

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun minCost(s: String, cost: IntArray): Long {
        var total = 0L
        for (c in cost) {
            total += c
        }
        val cnt = LongArray(26)
        for (i in s.indices) {
            cnt[s[i] - 'a'] += cost[i]
        }
        return total - cnt.max()
    }
}
