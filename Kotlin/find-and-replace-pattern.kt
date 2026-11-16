package findandreplacepattern

// Time:  O(n * l)
// Space: O(1)

class Solution {
    fun findAndReplacePattern(words: List<String>, pattern: String): List<String> {
        val result = ArrayList<String>()
        for (word in words) {
            if (match(word, pattern)) {
                result.add(word)
            }
        }
        return result
    }

    private fun match(word: String, pattern: String): Boolean {
        val lookup = HashMap<Char, Char>()
        val charSet = HashSet<Char>()
        for (i in word.indices) {
            val c = word[i]
            val p = pattern[i]
            if (c !in lookup) {
                if (p in charSet) {
                    return false
                }
                charSet.add(p)
                lookup[c] = p
            }
            if (lookup[c] != p) {
                return false
            }
        }
        return true
    }
}
