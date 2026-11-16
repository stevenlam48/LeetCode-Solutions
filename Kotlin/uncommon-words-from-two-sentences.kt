package uncommonwordsfromtwosentences

// Time:  O(m + n)
// Space: O(m + n)

class Solution {
    fun uncommonFromSentences(A: String, B: String): List<String> {
        val count = HashMap<String, Int>()
        for (word in (A + " " + B).split(" ")) {
            if (word.isEmpty()) {
                continue
            }
            count[word] = (count[word] ?: 0) + 1
        }
        val result = ArrayList<String>()
        for ((word, c) in count) {
            if (c == 1) {
                result.add(word)
            }
        }
        return result
    }
}
