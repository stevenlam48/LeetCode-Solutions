package mergestringsalternately

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder()
        var i = 0
        while (i < word1.length || i < word2.length) {
            if (i < word1.length) {
                result.append(word1[i])
            }
            if (i < word2.length) {
                result.append(word2[i])
            }
            ++i
        }
        return result.toString()
    }
}
