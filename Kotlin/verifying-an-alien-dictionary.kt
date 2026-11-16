package verifyinganaliendictionary
// Time:  O(n * l), l is the average length of words
// Space: O(1)

class Solution {
    fun isAlienSorted(words: List<String>, order: String): Boolean {
        val lookup = IntArray(order.length)
        for (i in order.indices) {
            lookup[order[i] - 'a'] = i
        }
        for (i in 0 until words.size - 1) {
            val word1 = words[i]
            val word2 = words[i + 1]
            var j = 0
            while (j < minOf(word1.length, word2.length)) {
                if (word1[j] != word2[j]) {
                    if (lookup[word1[j] - 'a'] > lookup[word2[j] - 'a']) {
                        return false
                    }
                    break
                }
                ++j
            }
            if (j == minOf(word1.length, word2.length) && word1.length > word2.length) {
                return false
            }
        }
        return true
    }
}
