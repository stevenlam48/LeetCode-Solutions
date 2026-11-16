package mostcommonword
// Time:  O(m + n), m is the size of banned, n is the size of paragraph
// Space: O(m + n)

class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val lookup = banned.toHashSet()
        val counts = HashMap<String, Int>()
        val word = StringBuilder()
        for (c in paragraph) {
            if (c in 'a'..'z' || c in 'A'..'Z') {
                word.append(c.lowercaseChar())
            } else if (word.isNotEmpty()) {
                val current = word.toString()
                counts[current] = counts.getOrDefault(current, 0) + 1
                word.clear()
            }
        }
        if (word.isNotEmpty()) {
            val current = word.toString()
            counts[current] = counts.getOrDefault(current, 0) + 1
        }
        var result = ""
        for ((key, value) in counts) {
            if ((result.isEmpty() || value > counts.getValue(result)) && key !in lookup) {
                result = key
            }
        }
        return result
    }
}
