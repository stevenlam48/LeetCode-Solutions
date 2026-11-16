package truncatesentence
// Time:  O(n)
// Space: O(1)

class Solution {
    fun truncateSentence(s: String, k: Int): String {
        var remaining = k
        for (i in s.indices) {
            if (s[i] == ' ' && --remaining == 0) {
                return s.substring(0, i)
            }
        }
        return s
    }
}
