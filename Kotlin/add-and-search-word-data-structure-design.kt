package addandsearchworddatastructuredesign

// Time:  O(min(n, h)), per operation
// Space: O(min(n, h))

class WordDictionary {
    private class TrieNode {
        var isString = false
        val leaves = HashMap<Char, TrieNode>()
    }

    private val root = TrieNode()

    init {
        root.isString = true
    }

    fun addWord(word: String) {
        var p = root
        for (c in word) {
            if (!p.leaves.containsKey(c)) {
                p.leaves[c] = TrieNode()
            }
            p = p.leaves[c]!!
        }
        p.isString = true
    }

    fun search(word: String): Boolean {
        return searchWord(word, root, 0)
    }

    private fun searchWord(word: String, node: TrieNode, s: Int): Boolean {
        if (s == word.length) {
            return node.isString
        }
        if (node.leaves.containsKey(word[s])) {
            return searchWord(word, node.leaves[word[s]]!!, s + 1)
        } else if (word[s] == '.') {
            for (child in node.leaves.values) {
                if (searchWord(word, child, s + 1)) {
                    return true
                }
            }
        }
        return false
    }
}
