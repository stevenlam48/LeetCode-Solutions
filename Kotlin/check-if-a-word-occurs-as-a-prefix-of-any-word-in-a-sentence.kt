package checkifawordoccursasaprefixofanywordinasentence

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        if (sentence.startsWith(searchWord)) {
            return 1
        }
        val pattern = " $searchWord"
        val p = kmp(sentence, pattern)
        if (p == -1) {
            return -1
        }
        var spaces = 0
        for (i in 0..p) {
            if (sentence[i] == ' ') {
                ++spaces
            }
        }
        return 1 + spaces
    }

    private fun kmp(text: String, pattern: String): Int {
        val prefix = getPrefix(pattern)
        var j = -1
        for (i in text.indices) {
            while (j > -1 && pattern[j + 1] != text[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == text[i]) {
                ++j
            }
            if (j == pattern.length - 1) {
                return i - j
            }
        }
        return -1
    }

    private fun getPrefix(pattern: String): IntArray {
        val prefix = IntArray(pattern.length) { -1 }
        var j = -1
        for (i in 1 until pattern.length) {
            while (j > -1 && pattern[j + 1] != pattern[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == pattern[i]) {
                ++j
            }
            prefix[i] = j
        }
        return prefix
    }
}
