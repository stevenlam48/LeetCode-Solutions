package sumofprefixscoresofstrings

// Time:  O(n * l), n is the number of words, l is the max length of words
// Space: O(t), t is the size of trie

class Solution {
    fun sumPrefixScores(words: List<String>): IntArray {
        val trie = Trie()
        for (word in words) {
            trie.insert(word)
        }
        return IntArray(words.size) { trie.query(words[it]) }
    }

    private class Trie {
        private val nodes = mutableListOf<IntArray>()

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
                ++nodes[curr][26]
            }
        }

        fun query(s: String): Int {
            var result = 0
            var curr = 0
            for (c in s) {
                curr = nodes[curr][c - 'a']
                result += nodes[curr][26]
            }
            return result
        }

        private fun createNode(): Int {
            nodes.add(IntArray(27))
            return nodes.size - 1
        }
    }
}
