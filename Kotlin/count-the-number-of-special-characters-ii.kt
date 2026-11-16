package countthenumberofspecialcharactersii
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val lookup1 = IntArray(26) { word.length }
        val lookup2 = IntArray(26) { -1 }
        for (i in word.indices) {
            if (word[i].isLowerCase()) {
                lookup1[word[i] - 'a'] = i
            } else if (lookup2[word[i] - 'A'] == -1) {
                lookup2[word[i] - 'A'] = i
            }
        }
        var result = 0
        for (i in 0 until 26) {
            if (lookup1[i] < lookup2[i]) {
                ++result
            }
        }
        return result
    }
}
