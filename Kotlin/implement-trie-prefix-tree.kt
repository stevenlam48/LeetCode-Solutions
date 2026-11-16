package implementtrieprefixtree

// Time:  O(n), per operation
// Space: O(1)

class TrieNode {
    var is_string = false
    val leaves = HashMap<Char, TrieNode>()
}

class Trie {
    private val root_ = TrieNode()

    // Inserts a word into the trie.
    fun insert(word: String) {
        var cur = root_
        for (c in word) {
            cur = cur.leaves.getOrPut(c) { TrieNode() }
        }
        cur.is_string = true
    }

    // Returns if the word is in the trie.
    fun search(word: String): Boolean {
        val node = childSearch(word)
        return node?.is_string ?: false
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    fun startsWith(prefix: String): Boolean {
        return childSearch(prefix) != null
    }

    fun childSearch(word: String): TrieNode? {
        var cur = root_
        for (c in word) {
            cur = cur.leaves[c] ?: return null
        }
        return cur
    }
}
