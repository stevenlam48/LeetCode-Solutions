package splitstringsbyseparator

// Time:  O(n * l)
// Space: O(l)

class Solution {
    fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
        val result = mutableListOf<String>()
        for (word in words) {
            var left = 0
            for (right in 0..word.length) {
                if (right != word.length && word[right] != separator) {
                    continue
                }
                if (right - left > 0) {
                    result.add(word.substring(left, right))
                }
                left = right + 1
            }
        }
        return result
    }
}
