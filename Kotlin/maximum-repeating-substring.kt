package maximumrepeatingsubstring

// Time:  O(n), n is the length of sequence
// Space: O(m), m is the length of word

class Solution {
    fun maxRepeating(sequence: String, word: String): Int {
        if (sequence.length < word.length) {
            return 0
        }
        val prefix = getPrefix(word)
        var result = 0
        var count = 0
        var j = -1
        var prev = -1
        for (i in sequence.indices) {
            while (j > -1 && word[j + 1] != sequence[i]) {
                j = prefix[j]
            }
            if (word[j + 1] == sequence[i]) {
                ++j
            }
            if (j + 1 == word.length) {
                count = if (i - prev == word.length) count + 1 else 1
                result = maxOf(result, count)
                j = -1
                prev = i
            }
        }
        return result
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
