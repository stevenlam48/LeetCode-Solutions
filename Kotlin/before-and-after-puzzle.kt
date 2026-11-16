package beforeandafterpuzzle

// Time:  O(l * rlogr)  , l is the max length of phrases
//                      , r is the number of result, could be up to O(n^2)
// Space: O(l * (n + r)), n is the number of phrases

class Solution {
    fun beforeAndAfterPuzzles(phrases: Array<String>): List<String> {
        val lookup = HashMap<String, MutableList<Int>>()
        for (i in phrases.indices) {
            val phrase = phrases[i]
            val right = phrase.lastIndexOf(' ')
            val word = if (right == -1) phrase else phrase.substring(right + 1)
            lookup.getOrPut(word) { mutableListOf() }.add(i)
        }
        val resultSet = HashSet<String>()
        for (i in phrases.indices) {
            val phrase = phrases[i]
            val left = phrase.indexOf(' ')
            val word = if (left == -1) phrase else phrase.substring(0, left)
            val matches = lookup[word] ?: continue
            for (j in matches) {
                if (j == i) {
                    continue
                }
                resultSet.add(phrases[j] + phrase.substring(word.length))
            }
        }
        return resultSet.sorted()
    }
}
