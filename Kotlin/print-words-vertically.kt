package printwordsvertically

// Time:  O(n)
// Space: O(n)

class Solution {
    fun printVertically(s: String): List<String> {
        val words = s.trim().split(Regex("\\s+"))
        val maxLen = words.maxOf { it.length }
        val result = mutableListOf<String>()
        for (i in 0 until maxLen) {
            result.add(buildString {
                for (word in words) {
                    append(if (i < word.length) word[i] else ' ')
                }
            }.trimEnd(' '))
        }
        return result
    }
}
