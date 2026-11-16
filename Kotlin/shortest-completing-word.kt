package shortestcompletingword

// Time:  O(n)
// Space: O(1)

class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        var result = ""
        val counter = counts(licensePlate)
        for (word in words) {
            if ((result.isEmpty() || word.length < result.length) && contains(counter, word)) {
                result = word
            }
        }
        return result
    }

    private fun contains(counter1: IntArray, w2: String): Boolean {
        val counter2 = counts(w2)
        for (i in counter2.indices) {
            if (counter1[i] > counter2[i]) {
                return false
            }
        }
        return true
    }

    private fun counts(s: String): IntArray {
        val count = IntArray(26)
        for (c in s) {
            if (c.isLetter()) {
                ++count[c.lowercaseChar() - 'a']
            }
        }
        return count
    }
}
