package validword

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isValid(word: String): Boolean {
        if (word.length < 3) {
            return false
        }
        var vowel = false
        var consonant = false
        for (c in word) {
            if (c in 'a'..'z' || c in 'A'..'Z') {
                if (c.lowercaseChar() in "aeiou") {
                    vowel = true
                } else {
                    consonant = true
                }
            } else if (c !in '0'..'9') {
                return false
            }
        }
        return vowel && consonant
    }
}
