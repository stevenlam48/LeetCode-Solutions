package minimumnumberofkeypresses

// Time:  O(n)
// Space: O(1)

// greedy, sort
class Solution {
    fun minimumKeypresses(s: String): Int {
        val cnt = IntArray(26)
        for (c in s) {
            ++cnt[c - 'a']
        }
        cnt.sort()
        cnt.reverse()
        var result = 0
        for (i in cnt.indices) {
            result += cnt[i] * (i / 9 + 1)
        }
        return result
    }
}
