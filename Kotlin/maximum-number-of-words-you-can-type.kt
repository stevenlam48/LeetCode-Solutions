package maximumnumberofwordsyoucantype

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val lookup = brokenLetters.toHashSet()
        var result = 0
        var broken = false
        for (c in text) {
            if (c == ' ') {
                if (!broken) {
                    ++result
                }
                broken = false
            } else if (c in lookup) {
                broken = true
            }
        }
        return result + if (!broken) 1 else 0
    }
}
