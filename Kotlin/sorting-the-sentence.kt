package sortingthesentence

// Time:  O(n)
// Space: O(n)

class Solution {
    fun sortSentence(s: String): String {
        val words = s.split(" ").toMutableList()
        for (i in words.indices) {
            while (words[i].last() - '1' != i) {
                val j = words[i].last() - '1'
                val tmp = words[i]
                words[i] = words[j]
                words[j] = tmp
            }
        }
        return words.joinToString(" ") { it.substring(0, it.length - 1) }
    }
}
