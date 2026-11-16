package reportspammessage

// Time:  O(n + m)
// Space: O(m)

class Solution {
    fun reportSpam(message: List<String>, bannedWords: List<String>): Boolean {
        val THRESHOLD = 2

        val lookup = bannedWords.toHashSet()
        var cnt = 0
        for (m in message) {
            if (m !in lookup) {
                continue
            }
            if (++cnt == THRESHOLD) {
                break
            }
        }
        return cnt == THRESHOLD
    }
}
