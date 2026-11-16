package sentencesimilarityiii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        var s1 = sentence1
        var s2 = sentence2
        if (s1.length > s2.length) {
            val tmp = s1
            s1 = s2
            s2 = tmp
        }
        var count = 0
        for (step in 0 until 2) {
            for (i in 0..s1.length) {
                val c1 = if (i != s1.length) s1[if (step == 0) i else s1.length - 1 - i] else ' '
                val c2 = if (i != s2.length) s2[if (step == 0) i else s2.length - 1 - i] else ' '
                if (c1 != c2) {
                    break
                }
                if (c1 == ' ') {
                    ++count
                }
            }
        }
        return count >= s1.count { it == ' ' } + 1
    }
}
