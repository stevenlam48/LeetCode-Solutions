package camelcasematching

// Time:  O(n * l), n is number of queries
//                , l is length of query
// Space: O(1)

class Solution {
    fun camelMatch(queries: List<String>, pattern: String): List<Boolean> {
        val result = mutableListOf<Boolean>()
        for (query in queries) {
            result.add(isMatched(query, pattern))
        }
        return result
    }

    private fun isMatched(query: String, pattern: String): Boolean {
        var i = 0
        for (c in query) {
            if (i < pattern.length && pattern[i] == c) {
                ++i
            } else if (c.isUpperCase()) {
                return false
            }
        }
        return i == pattern.length
    }
}
