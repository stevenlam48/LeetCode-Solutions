package firstlettertoappeartwice

// Time:  O(n)
// Space: O(1)

class Solution {
    fun repeatedCharacter(s: String): Char {
        var result = '\u0000'
        val lookup = BooleanArray(26)
        for (c in s) {
            if (lookup[c - 'a']) {
                result = c
                break
            }
            lookup[c - 'a'] = true
        }
        return result
    }
}
