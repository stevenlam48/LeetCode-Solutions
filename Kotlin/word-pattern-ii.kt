package wordpatternii

// Time:  O(n * C(n - 1, c - 1)), n is length of str, c is unique count of pattern,
//                                there are H(n - c, c - 1) = C(n - 1, c - 1) possible splits of string,
//                                and each one costs O(n) to check if it matches the word pattern.
// Space: O(n + c) 

class Solution {
    fun wordPatternMatch(pattern: String, str: String): Boolean {
        return match(pattern, str, 0, 0, HashMap(), HashMap())
    }

    private fun match(
        pattern: String,
        str: String,
        i: Int,
        j: Int,
        wordToPattern: MutableMap<String, Char>,
        patternToWord: MutableMap<Char, String>
    ): Boolean {
        var isMatch = false
        if (i == pattern.length && j == str.length) {
            isMatch = true
        } else if (i < pattern.length && j < str.length) {
            val p = pattern[i]
            val mapped = patternToWord[p]
            if (mapped != null) {
                if (str.startsWith(mapped, j)) {
                    isMatch = match(pattern, str, i + 1, j + mapped.length, wordToPattern, patternToWord)
                }
            } else {
                var k = j
                while (k < str.length && !isMatch) {
                    val word = str.substring(j, k + 1)
                    if (word !in wordToPattern) {
                        wordToPattern[word] = p
                        patternToWord[p] = word
                        isMatch = match(pattern, str, i + 1, k + 1, wordToPattern, patternToWord)
                        wordToPattern.remove(word)
                        patternToWord.remove(p)
                    }
                    ++k
                }
            }
        }
        return isMatch
    }
}
