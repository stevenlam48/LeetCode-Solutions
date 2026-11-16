package checkifastringisanacronymofwords

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isAcronym(words: List<String>, s: String): Boolean {
        if (words.size != s.length) {
            return false
        }
        for (i in words.indices) {
            if (words[i][0] != s[i]) {
                return false
            }
        }
        return true
    }
}
