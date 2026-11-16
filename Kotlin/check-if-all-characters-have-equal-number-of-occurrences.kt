package checkifallcharactershaveequalnumberofoccurrences

// Time:  O(n)
// Space: O(1)

class Solution {
    fun areOccurrencesEqual(s: String): Boolean {
        val lookup = HashMap<Char, Int>()
        for (c in s) {
            lookup[c] = (lookup[c] ?: 0) + 1
        }
        val values = lookup.values
        for (v in values) {
            if (v != values.first()) {
                return false
            }
        }
        return true
    }
}
