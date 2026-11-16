package lengthofthelongestvalidsubstring

// Time:  O((m + n) * l), n = len(word), m = len(forbidden), l = max(len(w) for w in forbidden)
// Space: O(t), t is the size of trie

class Solution {
    fun longestValidSubstring(word: String, forbidden: List<String>): Int {
        val trie = Trie()
        for (w in forbidden) {
            trie.insert(w)
        }
        var result = 0
        var right = word.length - 1
        for (left in word.length - 1 downTo 0) {
            var i = left
            var curr = 0
            while (i <= right) {
                curr = trie.child(curr, word[i])
                if (curr == 0) {
                    break
                }
                if (trie.isString(curr)) {
                    right = i - 1
                    break
                }
                ++i
            }
            result = maxOf(result, right - left + 1)
        }
        return result
    }

    private class Trie {
        private val nodes = ArrayList<IntArray>()

        init {
            createNode()
        }

        fun insert(s: String) {
            var curr = 0
            for (c in s) {
                if (nodes[curr][c - 'a'] == 0) {
                    nodes[curr][c - 'a'] = createNode()
                }
                curr = nodes[curr][c - 'a']
            }
            ++nodes[curr][26]
        }

        fun child(curr: Int, c: Char): Int = nodes[curr][c - 'a']

        fun isString(curr: Int): Boolean = nodes[curr][26] != 0

        private fun createNode(): Int {
            nodes.add(IntArray(27))
            return nodes.size - 1
        }
    }
}
