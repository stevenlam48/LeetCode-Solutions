package findwordscontainingcharacter
// Time:  O(n * l)
// Space: O(1)

class Solution {
    fun findWordsContaining(words: List<String>, x: Char): List<Int> {
        val result = mutableListOf<Int>()
        for (i in words.indices) {
            if (words[i].contains(x)) {
                result.add(i)
            }
        }
        return result
    }
}
