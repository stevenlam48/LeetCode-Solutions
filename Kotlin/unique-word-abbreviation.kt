package uniquewordabbreviation

// Time:  ctor:   O(n), n is number of words in the dictionary. 
//        lookup: O(1)
// Space: O(k), k is number of unique words.

class ValidWordAbbr(dictionary: Array<String>) {
    private val lookup = HashMap<String, HashSet<String>>()

    init {
        for (word in dictionary) {
            val abbr = abbreviation(word)
            lookup.getOrPut(abbr) { HashSet() }.add(word)
        }
    }

    fun isUnique(word: String): Boolean {
        val abbr = abbreviation(word)
        return lookup[abbr].isNullOrEmpty() ||
            (lookup[abbr]?.contains(word) == true && lookup[abbr]?.size == 1)
    }

    private fun abbreviation(word: String): String {
        if (word.length <= 2) {
            return word
        }
        return word.first().toString() + word.length.toString() + word.last().toString()
    }
}
