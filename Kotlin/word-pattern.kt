package wordpattern

// Time:  O(n)
// Space: O(c), c is unique count of pattern

class Solution {
    fun wordPattern(pattern: String, str: String): Boolean {
        var count = if (str.isEmpty()) 0 else 1
        for (c in str) {
            if (c == ' ') ++count
        }
        if (pattern.length != count) return false

        val wordToPattern = HashMap<String, Char>()
        val patternToWord = HashMap<Char, String>()
        var i = 0
        for (p in pattern) {
            var j = str.indexOf(' ', i)
            if (j == -1) j = str.length
            val word = str.substring(i, j)
            if (word !in wordToPattern && p !in patternToWord) {
                wordToPattern[word] = p
                patternToWord[p] = word
            } else if (wordToPattern[word] != p) {
                return false
            }
            i = j + 1
        }
        return true
    }
}
