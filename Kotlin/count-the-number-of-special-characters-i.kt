package countthenumberofspecialcharactersi
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val lookup1 = BooleanArray(26)
        val lookup2 = BooleanArray(26)
        for (x in word) {
            if (x.isLowerCase()) {
                lookup1[x - 'a'] = true
            } else {
                lookup2[x - 'A'] = true
            }
        }
        var result = 0
        for (i in 0 until 26) {
            if (lookup1[i] == lookup2[i] && lookup2[i]) {
                ++result
            }
        }
        return result
    }
}
