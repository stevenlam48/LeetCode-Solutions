package vowelspellchecker
// Time:  O(n)
// Space: O(w)

class Solution {
    fun spellchecker(wordlist: List<String>, queries: Array<String>): Array<String> {
        val words = wordlist.toHashSet()
        val caps = HashMap<String, String>()
        val vows = HashMap<String, String>()
        for (word in wordlist) {
            val lower = tolow(word)
            caps.putIfAbsent(lower, word)
            vows.putIfAbsent(todev(lower), word)
        }
        for (i in queries.indices) {
            val query = queries[i]
            if (query in words) {
                continue
            }
            val lower = tolow(query)
            val devow = todev(lower)
            queries[i] = caps[lower] ?: vows[devow] ?: ""
        }
        return queries
    }

    private fun tolow(word: String): String {
        val chars = word.toCharArray()
        for (i in chars.indices) {
            chars[i] = chars[i].lowercaseChar()
        }
        return String(chars)
    }

    private fun todev(word: String): String {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
        val chars = word.toCharArray()
        for (i in chars.indices) {
            if (chars[i] in vowels) {
                chars[i] = '*'
            }
        }
        return String(chars)
    }
}
