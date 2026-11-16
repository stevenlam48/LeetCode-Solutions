package implementmagicdictionary

// Time:  O(n), n is the length of the word
// Space: O(d)

class MagicDictionary {
    private class TrieNode {
        var isString = false
        val leaves = HashMap<Char, TrieNode>()

        fun insert(s: String) {
            var p = this
            for (c in s) {
                p = p.leaves.getOrPut(c) { TrieNode() }
            }
            p.isString = true
        }
    }

    private val trie = TrieNode()

    fun buildDict(dict: List<String>) {
        for (s in dict) {
            trie.insert(s)
        }
    }

    fun search(word: String): Boolean {
        return find(word, trie, 0, true)
    }

    private fun find(word: String, curr: TrieNode, i: Int, mistakeAllowed: Boolean): Boolean {
        if (i == word.length) {
            return curr.isString && !mistakeAllowed
        }

        val next = curr.leaves[word[i]]
        if (next == null) {
            return if (mistakeAllowed) {
                curr.leaves.values.any { find(word, it, i + 1, false) }
            } else {
                false
            }
        }

        if (mistakeAllowed) {
            return find(word, next, i + 1, true) ||
                curr.leaves.any { (c, node) -> c != word[i] && find(word, node, i + 1, false) }
        }
        return find(word, next, i + 1, false)
    }
}
