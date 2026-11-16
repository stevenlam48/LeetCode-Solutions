package numberofmatchingsubsequences
// Time:  O(n + w), n is the size of S, w is the size of words
// Space: O(k), k is the number of words

class Solution {
    fun numMatchingSubseq(s: String, words: List<String>): Int {
        val waiting = HashMap<Char, MutableList<Pair<Int, Int>>>()
        for (i in words.indices) {
            waiting.getOrPut(words[i][0]) { mutableListOf() }.add(i to 1)
        }
        for (c in s) {
            val advance = waiting.remove(c).orEmpty()
            for (kvp in advance) {
                val i = kvp.first
                val j = kvp.second
                val next = if (j != words[i].length) words[i][j] else '\u0000'
                waiting.getOrPut(next) { mutableListOf() }.add(i to j + 1)
            }
        }
        return waiting['\u0000']?.size ?: 0
    }
}
