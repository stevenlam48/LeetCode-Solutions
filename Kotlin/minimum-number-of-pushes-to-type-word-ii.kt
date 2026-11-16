package minimumnumberofpushestotypewordii

// Time:  O(n)
// Space: O(26)

class Solution {
    fun minimumPushes(word: String): Int {
        val cnt = IntArray(26)
        for (x in word) {
            ++cnt[x - 'a']
        }
        cnt.sortDescending()
        var result = 0
        for (i in cnt.indices) {
            result += cnt[i] * (i / (9 - 2 + 1) + 1)
        }
        return result
    }
}
