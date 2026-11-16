package countingwordswithagivenprefix

// Time:  O(n * p)
// Space: O(1)

class Solution {
    fun prefixCount(words: List<String>, pref: String): Int {
        return words.count { it.startsWith(pref) }
    }
}
