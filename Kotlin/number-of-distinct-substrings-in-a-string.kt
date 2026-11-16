package numberofdistinctsubstringsinastring

// Time:  O(n^2)
// Space: O(t), t is the number of trie nodes

class Solution {
    fun countDistinct(s: String): Int {
        val trie = mutableListOf(IntArray(26))
        for (i in s.indices) {
            var curr = 0
            for (j in i until s.length) {
                val index = s[j] - 'a'
                if (trie[curr][index] == 0) {
                    trie.add(IntArray(26))
                    trie[curr][index] = trie.size - 1
                }
                curr = trie[curr][index]
            }
        }
        return trie.size - 1
    }
}
