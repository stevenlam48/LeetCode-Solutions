package wordabbreviation

// Time:  O(n * l) ~ O(n^2 * l^2)
// Space: O(n * l)

class Solution {
    fun wordsAbbreviation(dict: List<String>): List<String> {
        val abbrToWord = HashMap<String, MutableSet<String>>()
        val wordToAbbr = HashMap<String, String>()

        for (word in dict) {
            val prefix = word.substring(0, 1)
            abbrToWord.getOrPut(toAbbr(prefix, word)) { HashSet() }.add(word)
        }

        for ((abbr, words) in abbrToWord) {
            if (words.size > 1) {
                for (word in words) {
                    for (i in 2 until word.length) {
                        val prefix = word.substring(0, i)
                        if (isUnique(prefix, words)) {
                            wordToAbbr[word] = toAbbr(prefix, word)
                            break
                        }
                    }
                }
            } else {
                wordToAbbr[words.first()] = abbr
            }
        }

        return dict.map { wordToAbbr[it]!! }
    }

    private fun isUnique(prefix: String, words: Set<String>): Boolean {
        return words.count { it.startsWith(prefix) } == 1
    }

    private fun toAbbr(prefix: String, word: String): String {
        val abbr = prefix + (word.length - 1 - prefix.length).toString() + word.last()
        return if (abbr.length < word.length) abbr else word
    }
}
