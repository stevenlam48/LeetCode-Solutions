package countthenumberofconsistentstrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var result = words.size
        val lookup = BooleanArray(26)
        for (c in allowed) {
            lookup[c - 'a'] = true
        }
        for (word in words) {
            for (c in word) {
                if (!lookup[c - 'a']) {
                    --result
                    break
                }
            }
        }
        return result
    }
}
