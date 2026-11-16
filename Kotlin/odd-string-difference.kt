package oddstringdifference

// Time:  O(m * n), m is the number of words, n is the length of each word
// Space: O(1)

class Solution {
    fun oddString(words: List<String>): String {
        for (i in 0 until words[0].length - 1) {
            val lookup = LinkedHashMap<Int, MutableList<Int>>()
            for (j in words.indices) {
                val diff = words[j][i + 1] - words[j][i]
                val list = lookup.getOrPut(diff) { mutableListOf() }
                if (list.size < 2) {
                    list.add(j)
                }
            }
            if (lookup.size == 2) {
                val entries = lookup.entries.toList()
                return if (entries[0].value.size == 1) {
                    words[entries[0].value[0]]
                } else {
                    words[entries[1].value[0]]
                }
            }
        }
        return ""
    }
}
