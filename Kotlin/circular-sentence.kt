package circularsentence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isCircularSentence(sentence: String): Boolean {
        for (i in sentence.indices) {
            if (sentence[i] == ' ' && sentence[i - 1] != sentence[i + 1]) {
                return false
            }
        }
        return sentence.first() == sentence.last()
    }
}
