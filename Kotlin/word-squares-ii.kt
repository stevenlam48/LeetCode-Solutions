package wordsquaresii

// Time:  O(n^4)
// Space: O(n)

class Solution {
    fun wordSquares(words: List<String>): List<List<String>> {
        val sortedWords = words.sorted()
        val lookup = HashMap<Int, MutableList<Int>>()
        for (i in sortedWords.indices) {
            val word = sortedWords[i]
            lookup.getOrPut(word[0] - 'a') { mutableListOf() }.add(i)
            lookup.getOrPut((word[0] - 'a') + (word[3] - 'a' + 1) * 27) { mutableListOf() }.add(i)
        }
        val result = mutableListOf<List<String>>()
        for (i in sortedWords.indices) {
            val first = sortedWords[i]
            for (j in lookup[first[0] - 'a'].orEmpty()) {
                if (j == i) continue
                for (k in lookup[first[3] - 'a'].orEmpty()) {
                    if (k == i || k == j) continue
                    val key = (sortedWords[j][3] - 'a') + (sortedWords[k][3] - 'a' + 1) * 27
                    for (l in lookup[key].orEmpty()) {
                        if (l == i || l == j || l == k) continue
                        result.add(listOf(sortedWords[i], sortedWords[j], sortedWords[k], sortedWords[l]))
                    }
                }
            }
        }
        return result
    }
}
