package wordbreak

// Time:  O(n * l^2), l is the max length of the words.
// Space: O(n)

class Solution {
    fun wordBreak(s: String, wordDict: Set<String>): Boolean {
        val n = s.length
        val maxLen = wordDict.maxOfOrNull { it.length } ?: 0
        val canBreak = BooleanArray(n + 1)
        canBreak[0] = true
        for (i in 1..n) {
            for (l in 1..maxLen) {
                if (i - l < 0) break
                if (canBreak[i - l] && s.substring(i - l, i) in wordDict) {
                    canBreak[i] = true
                    break
                }
            }
        }
        return canBreak[n]
    }
}
