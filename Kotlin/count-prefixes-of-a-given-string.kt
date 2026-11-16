package countprefixesofagivenstring

// Time:  O(n * l)
// Space: O(1)

class Solution {
    fun countPrefixes(words: List<String>, s: String): Int {
        var result = 0
        for (word in words) {
            if (s.startsWith(word)) {
                ++result
            }
        }
        return result
    }
}
